package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Artifacts.Azione.Attacco;
import com.eswproject.lightsouls.Domain.Artifacts.Azione.Difesa;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

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
    void addCombinationToActions(Titanite titanite) {

        for (Difesa difesa : this.getDifese()) {
            if (difesa.getCombination().containsKey(titanite.getDiceColor())) {
                difesa.getCombination().put(titanite.getDiceColor(), difesa.getCombination().get(titanite.getDiceColor()) + 1);
            } else {
                difesa.getCombination().put(titanite.getDiceColor(), 1);
            }
        }
        this.getEquippedTitaniti().add(titanite);
        for (Attacco attacco : this.attacchi) {
            if (attacco.getClass().getSimpleName().equals(this.getClass().getSimpleName())) {
                if (attacco.getCombination().containsKey(titanite.getDiceColor())) {
                    attacco.getCombination().put(titanite.getDiceColor(), attacco.getCombination().get(titanite.getDiceColor()) + 1);
                } else {
                    attacco.getCombination().put(titanite.getDiceColor(), 1);
                }
            }
        }
    }

    @Override
    void removeCombinationToActions(Titanite titanite){
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
        for(Attacco attacco: this.getAttacchi())
        {

            if (attacco.getCombination().containsKey(titanite.getDiceColor()) && attacco.getClass().getSimpleName().equals(this.getClass().getSimpleName()))
            {
                if (attacco.getCombination().get(titanite.getDiceColor())>1)
                    attacco.getCombination().put(titanite.getDiceColor(), attacco.getCombination().get(titanite.getDiceColor())-1);
                else
                    attacco.getCombination().remove(titanite.getDiceColor());

            }
        }
    }
}

