package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.CostruttoreModalita;
import com.eswproject.lightsouls.Domain.Combattimento.Incontro;
import com.eswproject.lightsouls.Domain.Partita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class PartitaController {



    @Autowired
    CostruttoreModalita cM;
    Partita partita=new Partita();

    @GetMapping("/ProcediAdIncontro")
    public Incontro ProcediAdIncontro()
    {
        if(this.partita.getDungeonCorrente().isComplete())
        {
            if(this.partita.getIterDungeons().hasNext()){
                this.partita.nextDungeon();
                this.partita.getDungeonCorrente().nextIncontro();
            }
            else
                return null;
        }
        return this.partita.getDungeonCorrente().getIncontroCorrente();
    }

    @GetMapping("/AvviaIncontro")
    public String AvviaIncontro(){
        return this.partita.getDungeonCorrente().getIncontroCorrente().Avvia();
    }

    @GetMapping("/ModalitaStoria")
    public String CostruisciModalitaStoria()
    {
        cM.reset();
        cM.SetupModalita();
        partita.setM(cM.getM());
        partita.InitModalita();
        return "/Falo";
    }

    @GetMapping("/Termina")
    public String Termina(){
        return "/Giocatore";
    }



}
