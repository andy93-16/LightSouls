package com.eswproject.lightsouls.Domain;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Observable;

public class Incontro extends Observable
{

	private descrittoreIncontro descrittoreIncontro;

	public Incontro(descrittoreIncontro descrittoreIncontro)
	{
		this.descrittoreIncontro = descrittoreIncontro;
	}

	public String Avvia()
	{
		setChanged();
		notifyObservers();
		return "/Falo";
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
