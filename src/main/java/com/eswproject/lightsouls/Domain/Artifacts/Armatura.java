package com.eswproject.lightsouls.Domain.Artifacts;


import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Armatura")
public class Armatura extends Equipment
{
    @Override
    public void addTitanite(Titanite titanite)
    {
        this.getEquippedTitaniti().add(titanite);
        for(Azione azione: this.getAzioni())
        {
            if (azione.getCombination().containsKey(titanite.getDiceColor()))
            {
                azione.getCombination().put(titanite.getDiceColor(), azione.getCombination().get(titanite.getDiceColor())+1);
            }
            else
            {
                azione.getCombination().put(titanite.getDiceColor(),1);
            }
        }

    }
    @Override
    public void removeTitanite(Titanite titanite){

        this.getEquippedTitaniti().remove(titanite);
        for(Azione azione: this.getAzioni())
        {
            if (azione.getCombination().containsKey(titanite.getDiceColor()))
            {
                if (azione.getCombination().get(titanite.getDiceColor())>1)
                  azione.getCombination().put(titanite.getDiceColor(), azione.getCombination().get(titanite.getDiceColor())-1);
                else
                  azione.getCombination().remove(titanite.getDiceColor());

            }
        }
    }
}
