package com.eswproject.lightsouls.Domain;

public class Giocatore {

	private Personaggio personaggio;
	private Modalita modalita;

	public void SettaModalitaStoria() {
		Modalita modalita = new Modalita();
		modalita.ModalitaStoria();
		throw new UnsupportedOperationException();
	}

	public void IniziaNuovaPartita() {
		// TODO - implement Giocatore.IniziaNuovaPartita
		throw new UnsupportedOperationException();
	}

	public Personaggio getPersonaggio() {
		return this.personaggio;
	}

	/**
	 * 
	 * @param personaggio
	 */
	public void setPersonaggio(Personaggio personaggio) {
		this.personaggio = personaggio;
	}

}