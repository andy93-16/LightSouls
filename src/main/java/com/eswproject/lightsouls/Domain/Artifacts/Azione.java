package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.*;

import javax.persistence.*;
import java.util.Map;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Azione
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="dice_combination",joinColumns ={@JoinColumn(name="azione_id",referencedColumnName = "id")})
	@MapKeyColumn(name="dice_color")
	private Map<DiceColor, Integer> combination;


	public Map<DiceColor, Integer> getCombination() {
		return combination;
	}


//	public int getDanno()
//	{
//		Dice d = new Dice();
//		int danno = 0;
//		for(Map.Entry<DiceColor, Integer> dado : this.danno.entrySet())
//		{
//			danno += d.throw_Dice(dado.getKey(), dado.getValue());
//		}
//		return danno;
//	}
//
//	public void setDanno(DiceColor color, Integer dice)
//	{
//		this.danno.put(color, dice);
//	}
//
//	public void setType(AttaccoType t)
//	{
//		this.attaccoType = t;
//	}
//
//	public void setType(String t)
//	{
//		this.attaccoType = AttaccoType.valueOf(t);
//	}
}