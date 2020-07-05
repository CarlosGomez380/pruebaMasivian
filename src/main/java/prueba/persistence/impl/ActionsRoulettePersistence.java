package prueba.persistence.impl;

import org.springframework.stereotype.Service;
import prueba.persistence.RoulettePersistence;
import prueba.model.Roulette;

@Service("Action")
public class ActionsRoulettePersistence implements RoulettePersistence {

    public String addRoulette(){
        Roulette roulette= new Roulette();
        return roulette.getId();
    }


}
