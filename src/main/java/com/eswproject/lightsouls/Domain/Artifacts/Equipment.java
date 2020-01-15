package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Artifacts.Azione.Difesa;
import com.eswproject.lightsouls.Domain.Personaggio.BodyPart;
import com.eswproject.lightsouls.Domain.Personaggio.ClassName;
import com.eswproject.lightsouls.Domain.Personaggio.StatisticheBase;
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
	public int getId() {
		return id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private int upgrades;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Titanite> equippedTitaniti;

	@OneToOne
	private BodyPartRequirement bodyPartRequirement;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<ClassName> classi_compatibili;

	@Embedded
	private StatisticheBase minRequirements;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<BodyPart> equippedBodyParts;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Difesa> difese;

	public int getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(int upgrades) {
		this.upgrades = upgrades;
	}

	public BodyPartRequirement getBodyPartRequirement() {
		return bodyPartRequirement;
	}

	public List<Difesa> getDifese() {
		return difese;
	}

    public String getName()
    {
        return name;
    }

	public StatisticheBase getMinRequirements() {
		return minRequirements;
	}

	public List<BodyPart> getEquippedBodyParts() {
		return equippedBodyParts;
	}


	public List<Titanite> getEquippedTitaniti()
	{
		return equippedTitaniti;
	}

	public void addTitanite(Titanite titanite)
	{
		upgrades--;
		getEquippedTitaniti().add(titanite);
		addTitaniteToActions(titanite);
	}

	public void removeTitanite(Titanite titanite)
	{
		upgrades++;
		getEquippedTitaniti().remove(titanite);
		removeTitaniteFromActions(titanite);
	}

	abstract void removeTitaniteFromActions(Titanite titanite);
	abstract void addTitaniteToActions(Titanite titanite);




}