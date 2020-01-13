package com.eswproject.lightsouls.Domain.Partita;

import org.springframework.stereotype.Controller;

@Controller
public class CostruttoreModalitaStoria extends CostruttoreModalita {

    public void reset(){
        modalita=new Modalita();}

    public void SetupModalita(){
        modalita=service.findByName("storia");
    }

}