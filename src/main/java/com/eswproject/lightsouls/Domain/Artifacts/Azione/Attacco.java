package com.eswproject.lightsouls.Domain.Artifacts.Azione;

import com.eswproject.lightsouls.Domain.Artifacts.Azione.Azione;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Attacco")
public class Attacco extends Azione
{
	private int staminaCost;

	private int difficoltaSchivata;

	public int getStaminaCost() {
		return this.staminaCost;
	}

	public int getDifficoltaSchivata(){return this.difficoltaSchivata;}

}

