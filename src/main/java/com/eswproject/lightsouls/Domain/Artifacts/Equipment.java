package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "Arma", value = Arma.class),
        @JsonSubTypes.Type(name = "Armatura", value = Armatura.class)
})
public abstract class Equipment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int weight;

    public void setUpgradesLeft(int upgradesLeft)
    {
        this.upgradesLeft = upgradesLeft;
    }

    private int upgradesLeft;

    @OneToOne
    private StatisticaBase minRequirements;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Difesa> difese;


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

	public StatisticaBase getMinRequirements() {
		return minRequirements;
	}


	public List<Difesa> getDifese() {
		return difese;
	}

	public int getUpgradesLeft() {
		return upgradesLeft;
	}

    public int getWeight() {
        return weight;
    }
}