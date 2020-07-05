package prueba.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import prueba.model.Bet;
import prueba.persistence.RouletteException;
import prueba.services.RouletteService;
@RestController
@RequestMapping(value = "/roulette")
public class RouletteAPIController {
    @Autowired
    @Qualifier("rouletteServices")
    RouletteService rouletteService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addRoulette(){
        try{
            rouletteService.addRoulette();
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<?> openRoulette(@PathVariable() String id) {
        try {
            rouletteService.openRoulette(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RouletteException ex) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public ResponseEntity<?> betOnANumberOrColor(@PathVariable() String id, @RequestBody() Bet bet){
        try{
            rouletteService.betOnANumberOrColor(id, bet);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<?> endOfBet(@PathVariable() String id) {
        try {
            return new ResponseEntity<>(rouletteService.endOfBet(id), HttpStatus.ACCEPTED);
        } catch (RouletteException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<?> getAllRoulette() {
        try {
            return new ResponseEntity<>(rouletteService.getAllRoulette(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
