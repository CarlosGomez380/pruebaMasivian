package prueba.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.config.RedisConfig;
import prueba.persistence.RouletteException;
import prueba.persistence.RoulettePersistence;
import prueba.model.Roulette;
import prueba.repo.RouletteRepository;

@Service("Action")
public class ActionsRoulettePersistence implements RoulettePersistence {

    @Autowired
    private RouletteRepository rouletteRepository;

    public String addRoulette() {
        Roulette roulette = new Roulette();
        rouletteRepository.save(roulette);
        return roulette.getId();
    }

    public void openRoulette(String id) throws RouletteException {
        if(!rouletteRepository.existsById(id)){ throw new RouletteException("Operacion denegada"); }
        else{ rouletteRepository.findById(id).get().setOpen(true);}
    }


}
