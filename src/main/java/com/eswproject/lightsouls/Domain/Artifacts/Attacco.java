package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.Dice;
import com.eswproject.lightsouls.Domain.Dice.DiceColor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attacco extends Azione
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int staminaCost;
	public int getStaminaCost() {
		return this.staminaCost;
	}

	/**
	 * 
	 * @param staminaCost
	 */
	public void setStaminaCost(int staminaCost) {
		this.staminaCost = staminaCost;
	}

	public void setAttack()
	{
		Dice d = new Dice();
		//d.throw_Dice(DiceColor.BLACK);
	}
}