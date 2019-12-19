package com.eswproject.lightsouls.Domain.Artifacts;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    private List<Attacco> attacchi;

    @Override
    public void addTitanite(Titanite titanite)
    {
        this.getEquippedTitaniti().add(titanite);
        for(Attacco attacco: this.attacchi)
        {
            if(attacco.getClass().getSimpleName().equals("Attacco")) {
                if (attacco.getCombination().containsKey(titanite.getDiceColor())) {
                    attacco.getCombination().put(titanite.getDiceColor(), attacco.getCombination().get(titanite.getDiceColor()) + 1);
                } else {
                    attacco.getCombination().put(titanite.getDiceColor(), 1);
                }
            }
        }
    }


    @Override
    public void removeTitanite(Titanite titanite){
        this.getEquippedTitaniti().remove(titanite);
        for(Attacco attacco: this.getAzioni())
        {

            if (azione.getCombination().containsKey(titanite.getDiceColor()) && azione.getClass().getSimpleName().equals("Attacco"))
            {
                if (azione.getCombination().get(titanite.getDiceColor())>1)
                    azione.getCombination().put(titanite.getDiceColor(), azione.getCombination().get(titanite.getDiceColor())-1);
                else
                    azione.getCombination().remove(titanite.getDiceColor());

            }
        }
    }
}

