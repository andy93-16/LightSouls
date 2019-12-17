package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;


@RestController
@CrossOrigin("http://localhost:4200")
public class PartitaController implements Observer {

    @Autowired
    CostruttoreModalita cM;

    @Autowired
    IncontroController incontroController ;

    Iterator<DescrittoreDungeon> iterDungeons;

    Iterator<DescrittoreIncontro> iterIncontri;

    Modalita m;

    private boolean dungeonComplete=false;


    private void InitModalita()
    {
        this.iterDungeons=this.m.getListaDungeons().iterator();
        nextDungeon();
        nextIncontro();
    }

    private void nextIncontro()
    {
        this.incontroController.setDescrittoreIncontro(iterIncontri.next().clone());
        this.incontroController.addObserver(this);
    }

    private void nextDungeon()
    {
        this.iterIncontri=this.iterDungeons.next().getListaIncontri().iterator();
        this.dungeonComplete=false;
    }

    @GetMapping("/ProcediAdIncontro")
    public IncontroController ProcediAdIncontro(){
        if(this.dungeonComplete){
            if(this.iterDungeons.hasNext()){
                nextDungeon();
                nextIncontro();
            }
            else return null;
        }
        return incontroController ;
    }

    @Override
    public void update(Observable incontro, Object stato)
    {
        if(iterIncontri.hasNext())
            nextIncontro();
        else
            dungeonComplete=true;
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

    @GetMapping("/Termina")
    public String Termina(){
        return "/Giocatore";
    }



}
