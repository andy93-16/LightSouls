package com.eswproject.lightsouls.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class Partita {

	@Autowired
	costruttoreModalita cM;
	Dungeon dungeonCorrente;
	Incontro incontroCorrente;
	Modalita m;

	@GetMapping("/ModalitaStoria")
	public String CostruisciModalitaStoria() {
		this.cM.reset();
		this.cM.SetupModalita();
        this.m=cM.getM();
        //System.out.println(this.m.getListaDungeons().get(0).BossName);
		return "/Falo";
	}


	public void Termina() {

	}
	@GetMapping("/AvviaIncontro")
	public String AvviaIncontro(){
		return "/Falo";
	}

}