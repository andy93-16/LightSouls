package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue(value = "Arma")
public class Arma extends Equipment
{
    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Attacco> attacchi;

    public List<Attacco> getAttacchi()
    {
        return attacchi;
    }

    @Override
    public void addDice(DiceColor c)
    {
        for(Attacco attacco: this.getAttacchi())
        {
            if (attacco.getCombination().containsKey(c))
            {
                attacco.getCombination().put(c, attacco.getCombination().get(c)+1);
            }
            else
            {
                attacco.getCombination().put(c,1);
            }
        }

    }
}

