package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
@CrossOrigin("http://localhost:4200")
public class PartitaController {

    @Autowired
    CostruttoreModalita cM;

    @Autowired
    DungeonController dungeonCorrente;

    Iterator<DescrittoreDungeon> iterDungeons;

    Modalita m;


    public void InitModalita()
    {
        this.iterDungeons=this.m.getListaDungeons().iterator();
        nextDungeon();
        this.dungeonCorrente.nextIncontro();
    }


    @GetMapping("/ModalitaStoria")
    public String CostruisciModalitaStoria()
    {

        this.cM.reset();
        this.cM.SetupModalita();
        this.m=cM.getM();
        InitModalita();
        return "/Falo";
    }





    public void nextDungeon()
    {
        this.dungeonCorrente.setIterIncontri(this.iterDungeons.next().getListaIncontri().iterator());
    }


    @GetMapping("/Termina")
    public String Termina(){
        return "/Giocatore";
    }



}
