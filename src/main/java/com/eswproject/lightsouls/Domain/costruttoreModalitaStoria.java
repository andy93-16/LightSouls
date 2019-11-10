package com.eswproject.lightsouls.Domain;
import com.eswproject.lightsouls.Service.modalitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class costruttoreModalitaStoria extends costruttoreModalita {



    public Modalita getM() {
        return m;
    }

    public void reset(){
        this.m=new Modalita();}

    public void SetupModalita(){

        this.m=this.service.findByName("storia");
    }

}