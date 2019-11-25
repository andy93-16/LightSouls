package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.*;

import java.util.HashMap;

public abstract class Azione
{

	private HashMap<DiceColor, Integer> danno;
	private Type type;

	public Azione()
	{
		this.danno = new HashMap<>();
	}

	public int getDanno()
	{
		Dice d = new Dice();
		int danno = 0;
		for(HashMap.Entry<DiceColor, Integer> dado : this.danno.entrySet())
		{
			danno += d.throw_Dice(dado.getKey(), dado.getValue());
		}
		return danno;
	}

	public void setDanno(DiceColor color, Integer dice)
	{
		this.danno.put(color, dice);
	}
}