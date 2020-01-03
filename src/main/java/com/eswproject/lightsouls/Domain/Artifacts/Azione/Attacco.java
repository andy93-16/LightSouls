package com.eswproject.lightsouls.Domain.Artifacts.Azione;

import com.eswproject.lightsouls.Domain.Artifacts.Azione.Azione;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Attacco")
public class Attacco extends Azione
{
	private int staminaCost;

	public int getStaminaCost() {
		return this.staminaCost;
	}

}

