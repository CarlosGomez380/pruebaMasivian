package prueba.persistence.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.model.Bet;
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
    public void betOnANumberOrColor(String id, Bet bet) throws RouletteException{
        bet.invalidColor();
        bet.invalidNumber();
        if(!rouletteRepository.existsById(id) ||
                rouletteRepository.findById(id).get().isOpen()== false ||
                bet.getAmount()>10000 ||
                bet.getAmount()<0 ||
                (bet.getColor()=="White" && bet.getNumbers().isEmpty())) {
            throw new RouletteException("Operacion denegada"); }
        else{
            rouletteRepository.findById(id).get().getBets().add(bet);
        }
    }
}
