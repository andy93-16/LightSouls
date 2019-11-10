package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Service.modalitaService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class costruttoreModalita {

	@Autowired
	private modalitaService service;

	private Modalita m;

	abstract void reset();

	abstract void SetupModalita();

	abstract Modalita getM();


}