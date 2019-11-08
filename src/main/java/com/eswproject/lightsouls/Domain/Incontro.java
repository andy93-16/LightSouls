package com.eswproject.lightsouls.Domain;

import org.springframework.stereotype.Component;


public class Incontro extends Osservabile {

	descrittoreIncontro descIncontro;

	Incontro(descrittoreIncontro descrittoreIncontro){
		this.descIncontro=descrittoreIncontro;
	}

	void Avvia() {
		Notify();
	}

}
