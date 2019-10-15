package com.eswproject.lightsouls.Domain;

public class Partita {
	private Modalita modalita;

	public Partita(){
		this.modalita=new Modalita();
	}

	public void Termina() {
		// TODO - implement Partita.Termina
		throw new UnsupportedOperationException();
	}

	public Modalita getModalita() {
		return this.modalita;
	}

	/**
	 * 
	 * @param modalita
	 */
	public void setModalita(Modalita modalita) {
		this.modalita = modalita;
	}

}