package com.eswproject.lightsouls.Domain;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

@RestController
@CrossOrigin("http://localhost:4200")
public class Dungeon extends Observable implements Observer {

	Iterator<descrittoreIncontro> iterIncontri;
	Incontro incontroCorrente ;


	@Override
	public void update(Observable incontro,Object stato){
		if(iterIncontri.hasNext()) {
			nextIncontro();
		}
		else notifyObservers();
	}

	@GetMapping("/AvviaIncontro")
	public Dungeon AvviaIncontro(){
		this.incontroCorrente.Avvia();
		return this;
	}

	void nextIncontro() {
		this.incontroCorrente=new Incontro(iterIncontri.next().clone());
		this.incontroCorrente.addObserver(this);
	}

	void resettaIncontri(){}

}