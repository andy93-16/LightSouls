package com.eswproject.lightsouls.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class GiocatoreController {

    @GetMapping("/Modalita")
    public String IniziaNuovaPartita() {
        return "/Modalita";
    }


}
