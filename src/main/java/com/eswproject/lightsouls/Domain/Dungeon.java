package com.eswproject.lightsouls.Domain;

import java.util.Iterator;

public class Dungeon extends Osservabile implements Osservatore{

	Iterator<descrittoreIncontro> iterIncontri;
	Incontro incontroCorrente ;

	@Override
	public void Update(){
		System.out.println(incontroCorrente.descIncontro.getIdDescrittoreIncontro());
		if(iterIncontri.hasNext()) {
			nextIncontro();
		}
		else Notify();

	}
	void nextIncontro() {
		incontroCorrente=new Incontro(iterIncontri.next().clone());
		incontroCorrente.Subscribe(this);
	}
	void resettaIncontri() {
	}

}