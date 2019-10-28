package com.eswproject.lightsouls.Domain;
import com.eswproject.lightsouls.Service.modalitaService;
import org.springframework.stereotype.Controller;

@Controller
public class costruttoreModalitaStoria extends costruttoreModalita {

    modalitaService service;
    Modalita m;

    public costruttoreModalitaStoria(){
        this.service=new modalitaService();
    }

    public Modalita getM() {
        return m;
    }

    public void reset(){
        this.m=new Modalita();}

    public void SetupModalita(){
        this.service.findByName("storia");
    }

}