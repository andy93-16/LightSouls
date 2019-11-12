package com.eswproject.lightsouls.Domain;

import java.util.Observable;


public class Incontro extends Observable
{

	private DescrittoreIncontro descrittoreIncontro;

	public Incontro(DescrittoreIncontro descrittoreIncontro)
	{
		this.descrittoreIncontro = descrittoreIncontro;
	}

	public void avvia()
	{
		notifyObservers(this);
	}

	public DescrittoreIncontro getDescrittoreIncontro()
	{
		return descrittoreIncontro;
	}

	public void setDescrittoreIncontro(DescrittoreIncontro descrittoreIncontro)
	{
		this.descrittoreIncontro = descrittoreIncontro;
	}

//	@Override
//	public String toString()
//	{
//		//return super.toString();
//		return "{" +
//				"\"descrittoreIncontro\":" + this.descrittoreIncontro +
//				"}";
//	}
}
