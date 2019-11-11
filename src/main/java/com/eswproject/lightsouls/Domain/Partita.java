package com.eswproject.lightsouls.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

@RestController
@CrossOrigin("http://localhost:4200")
public class Partita implements Observer {

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
		dungeonCorrente.addObserver(this);
		this.dungeonCorrente.iterIncontri=this.iterDungeons.next().getListaIncontri().iterator();
		this.dungeonCorrente.nextIncontro();
	}

	private void InitModalita(){
		this.iterDungeons=this.m.getListaDungeons().iterator();
     	nextDungeon();
	}

	@Override
	public void update(Observable dungeon,Object result){
		if(this.iterDungeons.hasNext()) {
			nextDungeon();
		}
	}
}