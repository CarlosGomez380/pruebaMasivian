package prueba.services;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import prueba.model.Bet;
import prueba.persistence.RouletteException;
import prueba.persistence.RoulettePersistence;
@Service("rouletteServices")
public class RouletteService {
    @Autowired
    @Qualifier("Action")
    RoulettePersistence roulettePersistence;
    public String addRoulette(){ return roulettePersistence.addRoulette(); }
    public void openRoulette(String id) throws RouletteException { roulettePersistence.openRoulette(id);}
    public void betOnANumberOrColor(String id,Bet bet) throws RouletteException{ roulettePersistence.betOnANumberOrColor(id,bet); }
}
