package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Domain.Combattimento.Incontro;

public class Dungeon
{

	public com.eswproject.lightsouls.Domain.Combattimento.Incontro getIncontroCorrente()
	{
		return this.incontroCorrente;
	}

	public void setIncontroCorrente(com.eswproject.lightsouls.Domain.Combattimento.Incontro incontroCorrente)
	{
		this.incontroCorrente = incontroCorrente;
	}

	private Incontro incontroCorrente;

}