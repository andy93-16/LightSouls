package com.eswproject.lightsouls.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
@CrossOrigin("http://localhost:4200")
public class Partita implements Osservatore {

	@Autowired
	costruttoreModalita cM;
	Iterator<descrittoreDungeon> iterDungeons;
	Dungeon dungeonCorrente;
	Modalita m;

	@GetMapping("/ModalitaStoria")
	public String CostruisciModalitaStoria() {
		this.cM.reset();
		this.cM.SetupModalita();
        this.m=cM.getM();
        InitModalita();
        return "/Falo";
	}

	private void nextDungeon(){
		dungeonCorrente=new Dungeon();
		dungeonCorrente.Subscribe(this);
		this.dungeonCorrente.iterIncontri=this.iterDungeons.next().getListaIncontri().iterator();
		Incontro i= new Incontro(dungeonCorrente.iterIncontri.next().clone());
		i.Subscribe(dungeonCorrente);
		this.dungeonCorrente.incontroCorrente=i;
	}

	private void InitModalita(){
		this.iterDungeons=this.m.getListaDungeons().iterator();
     	nextDungeon();
	}

	@GetMapping("/AvviaIncontro")
	public String AvviaIncontro(){
		this.dungeonCorrente.incontroCorrente.Avvia();
		return "/Falo";
	}

	@Override
	public void Update(){
		if(this.iterDungeons.hasNext()) {
			nextDungeon();
		}
	}

}