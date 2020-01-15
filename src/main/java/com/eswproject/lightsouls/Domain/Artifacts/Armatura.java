package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Artifacts.Azione.Difesa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Armatura")
public class Armatura extends Equipment {

    @Override
    void addTitaniteToActions(Titanite titanite) {

        for (Difesa difesa : this.getDifese()) {
            if (difesa.getCombination().containsKey(titanite.getDiceColor())) {
                difesa.getCombination().put(titanite.getDiceColor(), difesa.getCombination().get(titanite.getDiceColor()) + 1);
            } else {
                difesa.getCombination().put(titanite.getDiceColor(), 1);
            }
        }
    }

    @Override
    void removeTitaniteFromActions(Titanite titanite){
        for(Difesa difesa: this.getDifese())
        {
            if (difesa.getCombination().containsKey(titanite.getDiceColor()))
            {
                if (difesa.getCombination().get(titanite.getDiceColor())>1)
                    difesa.getCombination().put(titanite.getDiceColor(), difesa.getCombination().get(titanite.getDiceColor())-1);
                else
                    difesa.getCombination().remove(titanite.getDiceColor());

            }
        }
    }

}
