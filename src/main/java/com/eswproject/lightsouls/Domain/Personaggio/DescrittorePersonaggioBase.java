package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Arma;
import com.eswproject.lightsouls.Domain.Artifacts.Armatura;
import com.eswproject.lightsouls.Domain.Artifacts.Difesa;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "Nemico", value = DescrittoreNemico.class),
        @JsonSubTypes.Type(name = "Personaggio", value = DescrittorePersonaggio.class)
})
public abstract class DescrittorePersonaggioBase
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
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

    public String getNome() {
        return nome;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<Equipment> equipaggiati;

    public List<Equipment> getEquipaggiati() {
        return equipaggiati;
    }

    public int getDifesa(){
        int difesaTot=0;
        for(Equipment equipment: this.equipaggiati){
            for(Difesa difesa : equipment.getDifese())
                difesaTot+=difesa.getDiceRoll();
        }
        return difesaTot;
    }
}
