package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.Dice;

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

