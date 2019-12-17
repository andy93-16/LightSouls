package com.eswproject.lightsouls.Domain.Combattimento;

import javax.persistence.*;

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


}
