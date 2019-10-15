package com.eswproject.lightsouls.Domain;

import java.util.*;

public abstract class Modalita {

	public Dungeon getCurrentDungeon() {
		return this.currentDungeon;
	}

	public void setCurrentDungeon(Dungeon currentDungeon) {
		this.currentDungeon = currentDungeon;
	}
	private Dungeon currentDungeon;


}