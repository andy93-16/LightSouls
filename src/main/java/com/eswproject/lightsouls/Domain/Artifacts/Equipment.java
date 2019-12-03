package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.eswproject.lightsouls.Domain.StatisticaBase;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
//@DiscriminatorValue(value = "Equipment")
public class Equipment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public void setUpgradesLeft(int upgradesLeft)
    {
        this.upgradesLeft = upgradesLeft;
    }

    private int upgradesLeft;

    private SlotType slotType;

    @OneToOne
    private StatisticaBase minRequirements;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Attacco> attacchi;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Difesa> difese;



	public int getId() {
		return id;
	}

    public String getName()
    {
        return name;
    }

	public SlotType getSlotType() {
		return slotType;
	}

	public StatisticaBase getMinRequirements() {
		return minRequirements;
	}

	public List<Attacco> getAttacchi() {
		return attacchi;
	}

	public List<Difesa> getDifese() {
		return difese;
	}

	public int getUpgradesLeft() {
		return upgradesLeft;
	}

	public void addAttackDice(DiceColor c)
    {
        for(Attacco attacco: this.getAttacchi())
        {
            if (attacco.getCombination().containsKey(c))
            {
                attacco.getCombination().put(c, attacco.getCombination().get(c)+1);
            }
            else
            {
                attacco.getCombination().put(c,1);
            }
        }

    }
}