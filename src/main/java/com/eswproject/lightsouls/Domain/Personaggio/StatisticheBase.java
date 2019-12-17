package com.eswproject.lightsouls.Domain.Personaggio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatisticheBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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


}