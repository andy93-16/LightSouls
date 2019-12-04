package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.eswproject.lightsouls.Domain.StatisticaBase;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Attacco> attacchi;

    public Equipment()
    {
        this.slotType = SlotType.ARMATURA;
    }

    public void addDice(DiceColor c)
    {
        if(this.slotType == SlotType.ARMA)
        {
            for(Attacco attacco : this.getAttacchi())
            {
                if(attacco.getCombination().containsKey(c))
                {
                    attacco.getCombination().put(c, attacco.getCombination().get(c) + 1);
                }
                else
                {
                    attacco.getCombination().put(c, 1);
                }
            }
        }

        else
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
    }

	public int getId()
    {
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

    public void setDifese(List<Difesa> difese)
    {
        this.difese = difese;
    }

    public List<Attacco> getAttacchi()
    {
        return attacchi;
    }

    public void setAttacchi(List<Attacco> attacchi)
    {
        this.attacchi = attacchi;
    }
}