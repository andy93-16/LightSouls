package com.eswproject.lightsouls.Domain;

import java.util.Observable;

public class Incontro extends Observable
{

	private DescrittoreIncontro attribute;
	private descrittoreIncontro descrittoreIncontro;

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
		return attribute;
	}

	public void setAttribute(DescrittoreIncontro descrittoreIncontro)
	{
		this.attribute = descrittoreIncontro;
	}

	public descrittoreIncontro getDescrittoreIncontro() {
		return this.descrittoreIncontro;
	}

	public void setDescrittoreIncontro(descrittoreIncontro descrittoreIncontro) {
		this.descrittoreIncontro = descrittoreIncontro;
	}

}
