package prueba.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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

}
