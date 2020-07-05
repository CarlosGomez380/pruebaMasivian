package prueba.persistence;

import org.springframework.stereotype.Service;

@Service
public interface RoulettePersistence {

    public String addRoulette();
    public void openRoulette(String id) throws RouletteException;
}
