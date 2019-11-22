package com.eswproject.lightsouls.Domain;

import java.util.Observable;

public class Incontro extends Observable
{

	private DescrittoreIncontro descrittoreIncontro;

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

	public DescrittoreIncontro getAttribute()
	{
		return descrittoreIncontro;
	}

	public void setAttribute(DescrittoreIncontro descrittoreIncontro)
	{
		this.descrittoreIncontro = descrittoreIncontro;
	}

	public DescrittoreIncontro getDescrittoreIncontro() {
		return this.descrittoreIncontro;
	}

	public void setDescrittoreIncontro(DescrittoreIncontro descrittoreIncontro) {
		this.descrittoreIncontro = descrittoreIncontro;
	}

}
