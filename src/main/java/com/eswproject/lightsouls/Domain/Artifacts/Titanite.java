package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Titanite {

    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int looted;

    private int maxlootable;

    private int available;

    private int anime;

    private EquipmentType equipmentType;

    private DiceColor diceColor;

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public DiceColor getDiceColor() {
        return diceColor;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available)
    {
        this.available = available;
    }

    public int getLooted() {
        return looted;
    }

    public int getAnime() {
        return anime;
    }

    public int getMaxlootable() {
        return maxlootable;
    }
}



