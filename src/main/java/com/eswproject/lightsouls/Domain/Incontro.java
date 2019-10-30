package com.eswproject.lightsouls.Domain;

import java.util.Iterator;

public class Incontro {

	boolean isComplete=false;
	Iterator<descrittoreIncontro> iter;

	public Incontro(Iterator<descrittoreIncontro> iter){
		this.iter=iter;
	}

}
