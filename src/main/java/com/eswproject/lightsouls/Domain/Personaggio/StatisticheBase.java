package com.eswproject.lightsouls.Domain.Personaggio;

import javax.persistence.*;

@Embeddable
public class StatisticheBase {

	@Column(nullable = true)
	private int forza;
	@Column(nullable = true)
	private int destrezza;
	@Column(nullable = true)
	private int intelligenza;
	@Column(nullable = true)
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