package com.eswproject.lightsouls.Domain;

import java.util.Iterator;


public class Partita
{
    public void setM(Modalita m) {
        this.m = m;
    }

    Modalita m;

	public Iterator<DescrittoreDungeon> getIterDungeons() {
		return iterDungeons;
	}

	Iterator<DescrittoreDungeon> iterDungeons;

	public Dungeon getDungeonCorrente() {
		return dungeonCorrente;
	}

	Dungeon dungeonCorrente;
	//private Personaggio personaggio;

	public void InitModalita()
	{
		this.iterDungeons=this.m.getListaDungeons().iterator();
		nextDungeon();
		this.dungeonCorrente.nextIncontro();
	}


	public void nextDungeon()
	{
		this.dungeonCorrente=new Dungeon();
		this.dungeonCorrente.setIterIncontri(this.iterDungeons.next().getListaIncontri().iterator());
	}
}
