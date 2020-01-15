package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Artifacts.Azione.Attacco;
import com.eswproject.lightsouls.Domain.Artifacts.Azione.Difesa;
import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue(value = "Arma")
public class Arma extends Equipment{

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Attacco> attacchi;

    public List<Attacco> getAttacchi() {
        return attacchi;
    }

    @Override
    void addTitaniteToActions(Titanite titanite)
    {
        Map<DiceColor, Integer> diceCombo;
        DiceColor titaniteColor = titanite.getDiceColor();
        for (Attacco attacco : this.attacchi)
        {
            diceCombo = attacco.getCombination();
            if (diceCombo.containsKey(titaniteColor))
            {
                diceCombo.put(titaniteColor, diceCombo.get(titaniteColor) + 1);
            }
            else
            {
                diceCombo.put(titaniteColor, 1);
            }
        }
    }

    @Override
    void removeTitaniteFromActions(Titanite titanite)
    {
        System.out.println("remove pt.0");
        Map<DiceColor, Integer> diceCombo;
        DiceColor titaniteColor = titanite.getDiceColor();

        for(Iterator<Attacco> attacco = this.attacchi.iterator(); attacco.hasNext();)
        {
            System.out.println("remove pt.1");
            diceCombo = attacco.next().getCombination();
            if (diceCombo.containsKey(titaniteColor))
            {
                System.out.println("remove pt.2");
                if (diceCombo.get(titaniteColor)>1)
                {
                    System.out.println("remove pt.3 true");
                    diceCombo.put(titaniteColor, diceCombo.get(titaniteColor) - 1);
                }
                else
                {
                    System.out.println("remove pt.3 false");
                    diceCombo.remove(titaniteColor);
                }
            }
        }
    }
}

