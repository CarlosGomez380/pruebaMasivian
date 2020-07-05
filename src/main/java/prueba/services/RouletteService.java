package prueba.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import prueba.persistence.RoulettePersistence;

@Service("rouletteServices")
public class RouletteService {

    @Autowired
    @Qualifier("Action")
    RoulettePersistence roulettePersistence;

    public String addRoulette(){ return roulettePersistence.addRoulette(); }



}
