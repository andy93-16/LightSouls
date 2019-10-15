package com.eswproject.lightsouls.Domain;

public class Giocatore {

	private Partita partita;
	private Personaggio personaggio;

	public void SettaModalitaStoria() {
		throw new UnsupportedOperationException();
	}

	public void IniziaNuovaPartita() {
		Partita partita =new Partita();
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