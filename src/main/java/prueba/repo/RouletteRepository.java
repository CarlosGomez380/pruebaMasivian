package prueba.repo;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import prueba.model.Roulette;

@Repository
public interface RouletteRepository extends CrudRepository<Roulette, String>{}






