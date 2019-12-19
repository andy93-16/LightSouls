package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.Map;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(name = "Attacco", value = Attacco.class),
		@JsonSubTypes.Type(name = "Difesa", value = Difesa.class)
})
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

	public int getDiceRoll()
	{
		Dice d = new Dice();
		int danno = 0;
		for(Map.Entry<DiceColor, Integer> dado : this.combination.entrySet())
		{
			danno += d.throw_Dice(dado.getKey(), dado.getValue());
		}
		return danno;
	}

//	public void setDanno(DiceColor color, Integer dice)
//	{
//		this.combination.put(color, dice);
//	}


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