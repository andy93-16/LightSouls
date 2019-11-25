package com.eswproject.lightsouls.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatisticaBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int forza;
	private int destrezza;
	private int intelligenza;
	private int fede;

	public int getForza() {
		return this.forza;
	}

	public void setForza(int forza) {
		this.forza = forza;
	}

	public int getDestrezza() {
		return this.destrezza;
	}

	public void setDestrezza(int destrezza) {
		this.destrezza = destrezza;
	}

	public int getIntelligenza() {
		return this.intelligenza;
	}

	public void setIntelligenza(int intelligenza) {
		this.intelligenza = intelligenza;
	}

	public int getFede() {
		return this.fede;
	}

	public void setFede(int fede) {
		this.fede = fede;
	}

	public void getAttribute() {
		// TODO - implement StatisticaBase.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement StatisticaBase.setAttribute
		throw new UnsupportedOperationException();
	}

}