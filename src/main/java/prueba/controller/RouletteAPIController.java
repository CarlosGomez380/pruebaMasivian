package prueba.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import prueba.model.Bet;
import prueba.persistence.RouletteException;
import prueba.services.RouletteService;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Logger.getLogger(RouletteAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    @RequestMapping(value = {"/{id}/{color}/{amount}"}, method = RequestMethod.POST)
    public ResponseEntity<?> betOnANumberOrColor(@PathVariable() String id, @RequestBody() ArrayList<Integer> number, @PathVariable() String color, @PathVariable() int amount){
        Bet bet= new Bet(number,color,amount);
        try{
            rouletteService.betOnANumberOrColor(id, bet);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
