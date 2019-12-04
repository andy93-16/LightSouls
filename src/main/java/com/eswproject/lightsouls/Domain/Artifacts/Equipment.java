package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.eswproject.lightsouls.Domain.StatisticaBase;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

    protected SlotType slotType;

    @OneToOne
    private StatisticaBase minRequirements;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Difesa> difese;


    public Equipment()
    {
        this.slotType = SlotType.ARMATURA;
    }

    public void addDice(DiceColor c)
    {
        for(Difesa difesa : this.getDifese())
        {
            if(difesa.getCombination().containsKey(c))
            {
                difesa.getCombination().put(c, difesa.getCombination().get(c) + 1);
            }
            else
            {
                difesa.getCombination().put(c, 1);
            }
        }
    }

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


	public List<Difesa> getDifese() {
		return difese;
	}

	public int getUpgradesLeft() {
		return upgradesLeft;
	}


}