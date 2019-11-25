package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.*;

import javax.persistence.*;
import java.util.HashMap;

@MappedSuperclass
public abstract class Azione
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany
	private HashMap<DiceColor, Integer> danno = new HashMap<>();
	@OneToOne
	private Type type;

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