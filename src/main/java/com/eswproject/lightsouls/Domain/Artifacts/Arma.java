package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Arma")
public class Arma extends Equipment
{

    @Override
    public void addDice(DiceColor c)
    {
        for(Azione azione: this.getAzioni())
        {
            if(azione.getClass().getSimpleName().equals("Attacco")) {
                if (azione.getCombination().containsKey(c)) {
                    azione.getCombination().put(c, azione.getCombination().get(c) + 1);
                } else {
                    azione.getCombination().put(c, 1);
                }
            }
        }

    }
    @Override
    public void removeDice(DiceColor c){
        for(Azione azione: this.getAzioni())
        {
            if (azione.getCombination().containsKey(c) && azione.getClass().getSimpleName().equals("Attacco"))
            {
                if (azione.getCombination().get(c)>1)
                    azione.getCombination().put(c, azione.getCombination().get(c)-1);
                else
                    azione.getCombination().remove(c);

            }
        }
    }
}

