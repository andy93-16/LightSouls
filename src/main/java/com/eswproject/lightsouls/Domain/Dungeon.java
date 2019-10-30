package com.eswproject.lightsouls.Domain;

import java.util.Iterator;

public class Dungeon {

	boolean isComplete=false;
	Iterator<descrittoreDungeon> iter;

	public Dungeon(Iterator<descrittoreDungeon> iter){
		this.iter=iter;
	}
}