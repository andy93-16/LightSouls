package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;

import javax.persistence.*;

@Entity
//@DiscriminatorValue("Titanite")
public class Titanite {

    public int getId() {
        return id;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    private SlotType slotType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public DiceColor getDiceColor() {
        return diceColor;
    }

    private DiceColor diceColor;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available)
    {
        this.available = available;
    }

    private int available;

    public int getLooted() {
        return looted;
    }

    private int looted;

}

