package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;

import com.eswproject.lightsouls.Domain.Personaggio.BodyPart;
import com.eswproject.lightsouls.Domain.Personaggio.BodyPartType;
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

    @OneToOne
    private BodyPartRequirement bodyPartRequirement;

    public BodyPartRequirement getBodyPartRequirement() {
    return bodyPartRequirement;
}

    private int upgradesMax;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Titanite> equippedTitaniti;

    @OneToOne
    private StatisticaBase minRequirements;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Azione> azioni;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<BodyPart> equippedBodyParts;

    public List<BodyPart> getEquippedBodyParts() {
        return equippedBodyParts;
    }

    public List<Titanite> getEquippedTitaniti() {
        return equippedTitaniti;
    }

    public abstract void addDice(DiceColor c);

    public abstract void removeDice(DiceColor c);

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

    public List<Azione> getAzioni() {
        return azioni;
    }

	public int getUpgradesMax() {
		return upgradesMax;
	}
}