package com.eswproject.lightsouls.Domain;

import java.util.Observable;


public class Incontro extends Observable {

	descrittoreIncontro descIncontro;

	Incontro(descrittoreIncontro descrittoreIncontro){
		this.descIncontro=descrittoreIncontro;
	}

	void Avvia() {
		notifyObservers();
	}


}
