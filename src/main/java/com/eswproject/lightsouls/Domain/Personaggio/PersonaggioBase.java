package com.eswproject.lightsouls.Domain.Personaggio;


import com.eswproject.lightsouls.Domain.Artifacts.Arma;
import com.eswproject.lightsouls.Domain.Artifacts.Armatura;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "Personaggio", value = Personaggio.class),
        @JsonSubTypes.Type(name = "Nemico", value = Nemico.class)
})
public abstract class PersonaggioBase {

    public String getName() {
        return name;
    }

    @Id
    private String name;

    protected int HP_base;

    public int getVelocita_base() {
        return velocita_base;
    }

    private int velocita_base;

    public int getHP_base() {
        return HP_base;
    }




}
