package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
public abstract class PersonaggioBase
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int HP_max;
    private int velocita;

    public int getHP_max()
    {
        return this.HP_max;
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
}
