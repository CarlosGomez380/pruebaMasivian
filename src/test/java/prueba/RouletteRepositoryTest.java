package prueba;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prueba.config.RedisConfig;
import prueba.model.Roulette;
import prueba.repo.RouletteRepository;
import redis.embedded.RedisServerBuilder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class RouletteRepositoryTest {
    @Autowired
    private RouletteRepository rouletteRepository;
    private static redis.embedded.RedisServer redisServer;
    @BeforeClass
    public static void startRedisServer() throws IOException {
        redisServer = new RedisServerBuilder().port(6379).setting("maxmemory 128M").build();
        redisServer.start();
    }
    @AfterClass
    public static void stopRedisServer() throws IOException {
        redisServer.stop();
    }
    @Test
    public void whenSavingRoulette() throws Exception {
        final Roulette roulette = new Roulette();
        rouletteRepository.save(roulette);
        final Roulette retrievedRoulette = rouletteRepository.findById(roulette.getId()).get();
        assertEquals(roulette.getId(), retrievedRoulette.getId());
    }
}
