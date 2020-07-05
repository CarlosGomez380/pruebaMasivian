package prueba.persistence.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.model.Bet;
import prueba.persistence.RouletteException;
import prueba.persistence.RoulettePersistence;
import prueba.model.Roulette;
import prueba.repo.RouletteRepository;
import java.util.ArrayList;

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
        else{
            rouletteRepository.findById(id).get().getBets().clear();
            rouletteRepository.save(rouletteRepository.findById(id).get());
            updateRouletteState(id, true);
        }
    }
    public void betOnANumberOrColor(String id, Bet bet) throws RouletteException{
        bet.invalidAmount();
        bet.invalidNumber();
        if(!rouletteRepository.existsById(id) ||
                rouletteRepository.findById(id).get().isOpen()== false ||
                (bet.getColor().isEmpty() && bet.getNumbers().isEmpty())) {
            throw new RouletteException("Operacion denegada"); }
        else{
            rouletteRepository.findById(id).get().getBets().add(bet);
        }
    }
    public ArrayList<Bet> endOfBet(String id) throws RouletteException{
        if(!rouletteRepository.existsById(id)){ throw new RouletteException("Operacion denegada"); }
        else{
            updateRouletteState(id,false);
            System.out.println( rouletteRepository.findById(id).get().getBets().get(0).getNumbers());
            return rouletteRepository.findById(id).get().getBets();
        }
    }
    public void updateRouletteState(String id,boolean open){
        Roulette retrievedRoulette = rouletteRepository.findById(id).get();
        rouletteRepository.findById(id).get().setOpen(open);
        retrievedRoulette.setOpen(open);
        rouletteRepository.save(rouletteRepository.findById(id).get());
    }
}
