package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Personaggio.BodyPart;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;


public class Equipment {

    public DescrittoreEquipment getDescrittoreEquipment() {
        return descrittoreEquipment;
    }

    private DescrittoreEquipment descrittoreEquipment;

    private List<BodyPart> equippedBodyParts;

    public List<BodyPart> getEquippedBodyParts() {
        return equippedBodyParts;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Titanite> equippedTitaniti;

    public List<Titanite> getEquippedTitaniti() {
        return equippedTitaniti;
    }

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
