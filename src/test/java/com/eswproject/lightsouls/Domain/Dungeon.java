package com.eswproject.lightsouls.Domain;

import java.util.*;

public class Dungeon
{

	public Incontro getIncontroCorrente()
	{
		return this.incontroCorrente;
	}

	public void setIncontroCorrente(Incontro incontroCorrente)
	{
		this.incontroCorrente = incontroCorrente;
	}

	private Incontro incontroCorrente;

}