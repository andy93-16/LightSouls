package com.eswproject.lightsouls.Domain;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class Giocatore {

	Partita partita;
	Personaggio personaggio;

	@GetMapping("/Modalita")
	public String IniziaNuovaPartita() {
		this.partita=new Partita();
		return "/Modalita";
	}

}