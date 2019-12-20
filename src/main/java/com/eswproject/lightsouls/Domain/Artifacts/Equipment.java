package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Personaggio.BodyPart;

import java.util.List;


public class Equipment {

    public int getUpgradesLeft() {
        return upgradesLeft;
    }

    public void setUpgradesLeft(int upgradesLeft) {
        this.upgradesLeft = upgradesLeft;
    }

    private int upgradesLeft;

    public Equipment(DescrittoreEquipment descrittoreEquipment){
        this.descrittoreEquipment=descrittoreEquipment;
        this.upgradesLeft=descrittoreEquipment.getUpgradesMax();
        if(descrittoreEquipment instanceof Arma){
            Arma arma=(Arma)descrittoreEquipment;
            attacchi.addAll(arma.getAttacchi());}
        difese.addAll(descrittoreEquipment.getDifese());

    }

    public DescrittoreEquipment getDescrittoreEquipment() {
        return descrittoreEquipment;
    }

    private DescrittoreEquipment descrittoreEquipment;

    private List<BodyPart> equippedBodyParts;

    public List<BodyPart> getEquippedBodyParts() {
        return equippedBodyParts;
    }

    private List<Titanite> equippedTitaniti;

    public List<Attacco> getAttacchi() {
        return attacchi;
    }

    private List<Attacco> attacchi;

    public List<Difesa> getDifese() {
        return difese;
    }

    private List<Difesa> difese;

    public List<Titanite> getEquippedTitaniti() {
        return equippedTitaniti;
    }
    public void addTitanite(Titanite titanite){
        upgradesLeft=upgradesLeft-1;
        getEquippedTitaniti().add(titanite);
        addCombinationToActions(titanite);
    }
    public void removeTitanite(Titanite titanite){
        upgradesLeft=upgradesLeft+1;
        getEquippedTitaniti().remove(titanite);
        removeCombinatoToActions(titanite);

    }
    private void addCombinationToActions(Titanite titanite) {

        for (Difesa difesa : this.getDescrittoreEquipment().getDifese()) {
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

    private void removeCombinatoToActions(Titanite titanite){
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
