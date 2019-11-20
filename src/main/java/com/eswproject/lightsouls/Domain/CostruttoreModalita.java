package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Service.ModalitaService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CostruttoreModalita {

	@Autowired
	ModalitaService service;

	Modalita m;

	abstract void reset();

	abstract void SetupModalita();

	abstract Modalita getM();


}