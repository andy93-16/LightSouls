package com.eswproject.lightsouls.Domain.Artifacts;


import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Armatura")
public class Armatura extends Equipment
{
    @Override
    public void addDice(DiceColor c)
    {
        for(Azione azione: this.getAzioni())
        {
            if (azione.getCombination().containsKey(c))
            {
                azione.getCombination().put(c, azione.getCombination().get(c)+1);
            }
            else
            {
                azione.getCombination().put(c,1);
            }
        }

    }
    @Override
    public void removeDice(DiceColor c){
        for(Azione azione: this.getAzioni())
        {
            if (azione.getCombination().containsKey(c))
            {
                if (azione.getCombination().get(c)>1)
                  azione.getCombination().put(c, azione.getCombination().get(c)-1);
                else
                  azione.getCombination().remove(c);

            }
        }
    }
}
