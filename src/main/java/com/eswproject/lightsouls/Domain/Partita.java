package com.eswproject.lightsouls.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
@CrossOrigin("http://localhost:4200")
public class Partita
{

	@Autowired
	CostruttoreModalita cM;
	Iterator<DescrittoreDungeon> iterDungeons;
	Dungeon dungeonCorrente;
	Modalita m;
	private Personaggio personaggio;

	@GetMapping("/ModalitaStoria")
	public String CostruisciModalitaStoria()
	{
		this.cM.reset();
		this.cM.SetupModalita();
        this.m=cM.getM();
        InitModalita();
        return "/Falo";
	}

	private void nextDungeon()
	{
		this.dungeonCorrente=new Dungeon();
		this.dungeonCorrente.setIterIncontri(this.iterDungeons.next().getListaIncontri().iterator());
	}

	@GetMapping("/ProcediAdIncontro")
	public Incontro ProcediAdIncontro()
	{
		if(this.dungeonCorrente.getIsComplete())
		{
			if(iterDungeons.hasNext()){
			   nextDungeon();
			   this.dungeonCorrente.nextIncontro();
			}
			else
			   return null;
		}
		return this.dungeonCorrente.getIncontroCorrente();
	}

	@GetMapping("/AvviaIncontro")
	public String AvviaIncontro(){
		return this.dungeonCorrente.getIncontroCorrente().Avvia();
	}

	private void InitModalita()
	{
		this.iterDungeons=this.m.getListaDungeons().iterator();
     	nextDungeon();
     	this.dungeonCorrente.nextIncontro();
	}

	@GetMapping("/Termina")
	public String Termina(){
		return "/Giocatore";
	}
}