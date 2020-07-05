package prueba.repo;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import prueba.model.Roulette;

@Repository
public interface RouletteRepository extends CrudRepository<Roulette, String>{}

    /*
    public static final String ROULETTE_KEY = "ROULETTE";
    private HashOperations hashOperations;

    public void save(Roulette roulette) {
        hashOperations.put(ROULETTE_KEY, roulette.getId(), roulette);
    }

    public Roulette findById(String id) {
        return (Roulette) hashOperations.get(ROULETTE_KEY,id);
    }

     */





