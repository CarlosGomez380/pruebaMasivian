package prueba.persistence.impl;

import org.springframework.stereotype.Service;
import prueba.persistence.RoulettePersistence;
import prueba.model.Roulette;

@Service("Action")
public class ActionsRoulettePersistence implements RoulettePersistence {

    public String addRoulette(){ return new Roulette().getId(); }

    public void openRoulette(String id){

    }
}
