package com.eswproject.lightsouls.Domain.Partita;

import com.eswproject.lightsouls.Service.ModalitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public abstract class CostruttoreModalita {

	@Autowired
	ModalitaService service;

	protected Modalita modalita;

	public abstract void reset();

	public abstract void SetupModalita();

	public Modalita getModalita(){
		return modalita;
	};


}