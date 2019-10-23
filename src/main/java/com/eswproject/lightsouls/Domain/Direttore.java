package com.eswproject.lightsouls.Domain;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class Direttore {

	costruttoreModalita cm;

	@GetMapping("/ModalitaStoria")
	public String CostruisciModalitaStoria() {
        cm.reset();

		return "/Falo";
	}

	public void setCm(costruttoreModalita cm) {
		this.cm = cm;
	}



}