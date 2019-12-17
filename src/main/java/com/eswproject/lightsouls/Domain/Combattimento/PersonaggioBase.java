package com.eswproject.lightsouls.Domain.Combattimento;

public class PersonaggioBase
{
    private String nome;
    private int HP_max;
    private int velocita;



    public int getHP_max()
    {
        return this.HP_max;
    }

    public void setHP_max(int HP_max)
    {
        this.HP_max = HP_max;
    }

    public int getVelocita()
    {
        return this.velocita;
    }

    public void setVelocita(int velocita)
    {
        this.velocita = velocita;
    }
}
