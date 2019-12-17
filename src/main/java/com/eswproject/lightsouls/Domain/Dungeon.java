package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Domain.Combattimento.Incontro;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class Dungeon implements Observer
{

	private boolean complete=false;
	private Iterator<DescrittoreIncontro> iterIncontri;
	private Incontro incontroCorrente ;


	@Override
	public void update(Observable incontro, Object stato)
	{
		if(iterIncontri.hasNext())
			nextIncontro();
		else
			setComplete(true);

	}

	public void nextIncontro()
	{
		this.incontroCorrente=new Incontro(iterIncontri.next().clone());
		this.incontroCorrente.addObserver(this);
	}

	public void resettaIncontri()
	{}

	public void setIterIncontri(java.util.Iterator<DescrittoreIncontro> iterIncontri)
	{
		this.iterIncontri = iterIncontri;
	}

	public Incontro getIncontroCorrente()
	{
		return incontroCorrente;
	}

	public boolean isComplete() {
		return this.complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}
}