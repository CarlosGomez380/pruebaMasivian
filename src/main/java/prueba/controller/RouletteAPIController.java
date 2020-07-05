package prueba.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import prueba.persistence.RouletteException;
import prueba.services.RouletteService;

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

}
