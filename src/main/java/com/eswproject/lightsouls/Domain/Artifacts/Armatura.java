package com.eswproject.lightsouls.Domain.Artifacts;

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
        for(Difesa difesa: this.getDescrittoreEquipment().getDifese())
        {
            if (difesa.getCombination().containsKey(titanite.getDiceColor()))
            {
                difesa.getCombination().put(titanite.getDiceColor(), difesa.getCombination().get(titanite.getDiceColor())+1);
            }
            else
            {
                difesa.getCombination().put(titanite.getDiceColor(),1);
            }
        }

    }
    @Override
    public void removeTitanite(Titanite titanite){

        this.getEquippedTitaniti().remove(titanite);
        for(Difesa difesa: this.getDescrittoreEquipment().getDifese())
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
