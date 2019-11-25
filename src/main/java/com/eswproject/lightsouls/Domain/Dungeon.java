package com.eswproject.lightsouls.Domain;

import java.util.Observable;
import java.util.Observer;

public class Dungeon implements Observer
{

	private boolean complete=false;


	public void setComplete(boolean complete) {
		complete = complete;
	}

	private java.util.Iterator<DescrittoreIncontro> iterIncontri;
	private Incontro incontroCorrente ;


	@Override
	public void update(Observable incontro, Object stato)
	{
		if(iterIncontri.hasNext())
		{
			nextIncontro();
		}
		else{
			setComplete(true);
		}

	}

	public void nextIncontro()
	{
		this.incontroCorrente=new Incontro(iterIncontri.next().clone());
		this.incontroCorrente.addObserver(this);
	}

	public void resettaIncontri()
	{}

	public java.util.Iterator<DescrittoreIncontro> getIterIncontri()
	{
		return iterIncontri;
	}

	public void setIterIncontri(java.util.Iterator<DescrittoreIncontro> iterIncontri)
	{
		this.iterIncontri = iterIncontri;
	}

	public Incontro getIncontroCorrente()
	{
		return incontroCorrente;
	}

	public void setIncontroCorrente(Incontro incontroCorrente)
	{
		this.incontroCorrente = incontroCorrente;
	}

	public boolean isComplete() {
		return this.complete;
	}
}