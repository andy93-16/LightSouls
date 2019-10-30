package com.eswproject.lightsouls.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
@CrossOrigin("http://localhost:4200")
public class Partita {

	@Autowired
	costruttoreModalita cM;
	Incontro incontroCorrente;
	Dungeon dungeonCorrente;
	Modalita m;

	@GetMapping("/ModalitaStoria")
	public String CostruisciModalitaStoria() {
		this.cM.reset();
		this.cM.SetupModalita();
        this.m=cM.getM();

        return "/Falo";
	}

	private void InitModalita(){
		this.dungeonCorrente=new Dungeon(this.m.getListaDungeons().iterator());
		this.incontroCorrente=new Incontro(this.dungeonCorrente.iter.next().getListaIncontri().iterator());
	}

	public void Termina() {

	}
	@GetMapping("/AvviaIncontro")
	public String AvviaIncontro(){

		return "/Falo";
	}

}