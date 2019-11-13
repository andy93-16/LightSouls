package com.eswproject.lightsouls.Domain;

import java.util.Observable;


public class Incontro extends Observable
{

	private descrittoreIncontro descrittoreIncontro;

	public Incontro(descrittoreIncontro descrittoreIncontro)
	{
		this.descrittoreIncontro = descrittoreIncontro;
	}

	public void Avvia()
	{
		setChanged();
		notifyObservers();
	}

	public descrittoreIncontro getDescrittoreIncontro()
	{
		return descrittoreIncontro;
	}

	public void setDescrittoreIncontro(descrittoreIncontro descrittoreIncontro)
	{
		this.descrittoreIncontro = descrittoreIncontro;
	}

}
