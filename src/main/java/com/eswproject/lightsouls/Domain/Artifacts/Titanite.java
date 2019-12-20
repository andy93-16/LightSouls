package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;

import javax.persistence.*;

@Entity
public class Titanite
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int anime;

    private EquipmentType equipmentType;

    private DiceColor diceColor;

    private int available;

    private int looted;


    public int getId() {
        return id;
    }

    public int getAnime() {
        return anime;
    }

    public int getLooted() {
        return looted;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available)
    {
        this.available = available;
    }

    public DiceColor getDiceColor() {
        return diceColor;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }
}