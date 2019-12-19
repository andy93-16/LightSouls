package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
public abstract class DescrittorePersonaggioBase
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int HP;
    private int velocita;

    public int getHP_max()
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
}
