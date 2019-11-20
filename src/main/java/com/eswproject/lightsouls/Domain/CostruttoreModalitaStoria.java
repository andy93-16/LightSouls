package com.eswproject.lightsouls.Domain;
import org.springframework.stereotype.Controller;

@Controller
public class CostruttoreModalitaStoria extends CostruttoreModalita {


    public Modalita getM() {
        return m;
    }

    public void reset(){
        this.m=new Modalita();}

    public void SetupModalita(){

        this.m=this.service.findByName("storia");
    }

}