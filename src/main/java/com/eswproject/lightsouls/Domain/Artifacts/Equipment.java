package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Artifacts.Azione.Difesa;
import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.eswproject.lightsouls.Domain.Personaggio.BodyPart;
import com.eswproject.lightsouls.Domain.Personaggio.ClassName;
import com.eswproject.lightsouls.Domain.Personaggio.StatisticheBase;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	@ElementCollection(fetch = FetchType.EAGER)
	private List<ClassName> classi_compatibili;

	@Embedded
	private StatisticheBase minRequirements;

	public int getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(int upgrades) {
		this.upgrades = upgrades;
	}

	private int upgrades;

	@OneToOne
	private BodyPartRequirement bodyPartRequirement;

	public BodyPartRequirement getBodyPartRequirement() {
		return bodyPartRequirement;
	}

	public List<Difesa> getDifese() {
		return difese;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Difesa> difese;

    public String getName()
    {
        return name;
    }

	public StatisticheBase getMinRequirements() {
		return minRequirements;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<BodyPart> equippedBodyParts;

	public List<BodyPart> getEquippedBodyParts() {
		return equippedBodyParts;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Titanite> equippedTitaniti;

	public List<Titanite> getEquippedTitaniti() {
		return equippedTitaniti;
	}

	public void addTitanite(Titanite titanite){
		upgrades=upgrades-1;
		getEquippedTitaniti().add(titanite);
		addCombinationToActions(titanite);
	}
	public void removeTitanite(Titanite titanite){
		upgrades=upgrades+1;
		getEquippedTitaniti().remove(titanite);
		removeCombinatoToActions(titanite);

	}

	private void addCombinationToActions(Titanite titanite) {

		for (Difesa difesa : this.getDifese()) {
			if (difesa.getCombination().containsKey(titanite.getDiceColor())) {
				difesa.getCombination().put(titanite.getDiceColor(), difesa.getCombination().get(titanite.getDiceColor()) + 1);
			} else {
				difesa.getCombination().put(titanite.getDiceColor(), 1);
			}
		}
	}

	private void removeCombinatoToActions(Titanite titanite){
		for(Difesa difesa: this.getDifese())
		{
			if (difesa.getCombination().containsKey(titanite.getDiceColor()))
			{
				if (difesa.getCombination().get(titanite.getDiceColor())>1)
					difesa.getCombination().put(titanite.getDiceColor(), difesa.getCombination().get(titanite.getDiceColor())-1);
				else
					difesa.getCombination().remove(titanite.getDiceColor());

			}
		}
	}

}