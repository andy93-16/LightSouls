package com.eswproject.lightsouls.Domain;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class Dungeon implements Observer
{

	private boolean isComplete=false;

	public boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean complete) {
		isComplete = complete;
	}

	private Iterator<descrittoreIncontro> iterIncontri;
	private Incontro incontroCorrente ;


	@Override
	public void update(Observable incontro, Object stato)
	{
		if(iterIncontri.hasNext())
		{
			nextIncontro();
		}
		else{
			setIsComplete(true);
		}

	}

	public void nextIncontro()
	{
		this.incontroCorrente=new Incontro(iterIncontri.next().clone());
		this.incontroCorrente.addObserver(this);
	}

	public void resettaIncontri()
	{}

	public Iterator<descrittoreIncontro> getIterIncontri()
	{
		return iterIncontri;
	}

	public void setIterIncontri(Iterator<descrittoreIncontro> iterIncontri)
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
}