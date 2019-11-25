package com.eswproject.lightsouls.Domain;

import java.util.Observable;

public class Incontro extends Observable
{
	private DescrittoreIncontro descrittoreIncontro;
	boolean complete = false;

	public Incontro(DescrittoreIncontro descrittoreIncontro)
	{
		this.descrittoreIncontro = descrittoreIncontro;
	}

	public String Avvia()
	{
		setChanged();
		notifyObservers();
		return "/RisultatoIncontro";
	}
	

	public DescrittoreIncontro getDescrittoreIncontro() {
		return this.descrittoreIncontro;
	}

	public void setDescrittoreIncontro(DescrittoreIncontro descrittoreIncontro) {
		this.descrittoreIncontro = descrittoreIncontro;
	}

	public boolean isComplete() {
		return this.complete;
	}

	public void setComplete(boolean isComplete) {
		this.complete = isComplete;
	}

}
