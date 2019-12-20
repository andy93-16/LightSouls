package com.eswproject.lightsouls.Domain.Artifacts;

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
public abstract class DescrittoreEquipment
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



    @OneToOne
    private StatisticheBase minRequirements;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Difesa> difese;

    public List<Difesa> getDifese() {
        return difese;
    }
    

	public int getId() {
		return id;
	}

    public String getName()
    {
        return name;
    }

	public StatisticheBase getMinRequirements() {
		return minRequirements;
	}

	public int getUpgradesMax() {
		return upgradesMax;
	}
}