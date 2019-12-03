package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.Dice;

import javax.persistence.*;

@Entity
public class Attacco extends Azione
{
	private int staminaCost;

	public int getStaminaCost() {
		return this.staminaCost;
	}

	public void setAttack()
	{
		Dice d = new Dice();
		//d.throw_Dice(DiceColor.BLACK);
	}
}

