package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Service.ModalitaService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CostruttoreModalita {

	@Autowired
	ModalitaService service;

	Modalita m;

	public abstract void reset();

	public abstract void SetupModalita();

	public abstract Modalita getM();


}