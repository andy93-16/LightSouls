package com.eswproject.lightsouls.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class Partita {

	@Autowired
	costruttoreModalita cm;
	Dungeon dungeonCorrente;
	Incontro incontroCorrente;
	Modalita modalita;

	@GetMapping("/ModalitaStoria")
	public String CostruisciModalitaStoria() {
		this.cm=new costruttoreModalitaStoria();
		this.cm.reset();
		this.cm.SetupModalita();
        this.modalita=cm.getM();
		return "/Falo";
	}


	public void Termina() {

	}
	@GetMapping("/AvviaIncontro")
	public String AvviaIncontro(){
		return "/Falo";
	}

}