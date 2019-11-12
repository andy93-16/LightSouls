package com.eswproject.lightsouls.Domain;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

@RestController
@CrossOrigin("http://localhost:4200")
public class Dungeon extends Observable implements Observer
{

	private Iterator<descrittoreIncontro> iterIncontri;
	private Incontro incontroCorrente ;


	@Override
	public void update(Observable incontro, Object stato)
	{
		if(iterIncontri.hasNext())
		{
			nextIncontro();
		}
		else notifyObservers();
	}

	public void AvviaIncontro()
	{
		this.incontroCorrente.Avvia();
		//return this.incontroCorrente;
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