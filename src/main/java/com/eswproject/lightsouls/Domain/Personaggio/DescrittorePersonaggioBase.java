package com.eswproject.lightsouls.Domain.Personaggio;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "Nemico", value = DescrittoreNemico.class),
        @JsonSubTypes.Type(name = "Personaggio", value = DescrittorePersonaggio.class)
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class DescrittorePersonaggioBase
{
    @Id
    private String name;
    private int HP;
    private int velocita;

    public int getHP()
    {
        return this.HP;
    }

    public int getVelocita()
    {
        return this.velocita;
    }

    public String getName() {
        return name;
    }




}
