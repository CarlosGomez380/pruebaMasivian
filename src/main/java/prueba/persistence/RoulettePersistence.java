package prueba.persistence;
import org.springframework.stereotype.Service;
import prueba.model.Bet;
@Service
public interface RoulettePersistence {
    public String addRoulette();
    public void openRoulette(String id) throws RouletteException;
    public void betOnANumberOrColor(String id, Bet bet) throws RouletteException;
}
