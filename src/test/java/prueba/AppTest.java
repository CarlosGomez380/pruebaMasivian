package prueba;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.google.gson.Gson;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import prueba.config.RedisConfig;
import prueba.model.Bet;
import prueba.model.Roulette;
import prueba.repo.RouletteRepository;
import prueba.services.RouletteService;
import redis.embedded.RedisServerBuilder;
import java.io.IOException;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ App.class })
@ContextConfiguration(classes = RedisConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureMockMvc
public class AppTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private RouletteService services;
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
    public void shouldCreateRoulette() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.post("/roulette")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
    @Test
    public void shouldOpenRoulette() throws Exception {
        Roulette roulette= new Roulette();
        rouletteRepository.save(roulette);
        mvc.perform(
                MockMvcRequestBuilders.put("/roulette/"+roulette.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
    @Test
    public void shouldCreateABet() throws Exception {
        Roulette roulette= new Roulette();
        rouletteRepository.save(roulette);
        final Roulette retrievedRoulette = rouletteRepository.findById(roulette.getId()).get();
        retrievedRoulette.setOpen(true);
        roulette.setOpen(true);
        rouletteRepository.save(roulette);
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(32);
        numbers.add(10);
        Bet bet= new Bet(numbers, "Black", 200);
        String json = new Gson().toJson(numbers);
        mvc.perform(
                MockMvcRequestBuilders.post("/roulette/"+roulette.getId()+"/"+bet.getColor()+"/"+bet.getAmount())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }
}
