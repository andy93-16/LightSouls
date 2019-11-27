package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Giocatore;
import com.eswproject.lightsouls.Domain.Partita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class GiocatoreController {

    Giocatore giocatore=new Giocatore();

    @GetMapping("/Modalita")
    public String IniziaNuovaPartita() {
        return "/Modalita";
    }


}
