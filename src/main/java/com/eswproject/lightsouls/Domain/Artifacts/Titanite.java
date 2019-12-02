package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Titanite")
public class Titanite extends Artefatto{

    public DiceColor getDiceColor() {
        return diceColor;
    }

    private DiceColor diceColor;

    public int getAvailable() {
        return available;
    }

    private int available;

    public int getLooted() {
        return looted;
    }

    private int looted;

}

