package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;

import java.util.ArrayList;
import java.util.List;

public class GestoreEquipaggiamenti {

    private Personaggio personaggio;

    public void setP(Personaggio personaggio) {
        this.personaggio = personaggio;
    }

    public void Equipaggia(List<BodyPart> bodyParts, int equipmentId){
        for(BodyPart bodyPart : getLocalBodyPartList(bodyParts)) {
            bodyPart.setEquipped(true);
            getLocalEquipment(equipmentId).getEquippedBodyParts().add(bodyPart);
        }
    }

    public void Disequipaggia(int equipmentId){
        for(BodyPart bodyPart : getLocalEquipment(equipmentId).getEquippedBodyParts()) {
            bodyPart.setEquipped(false);
        }
        getLocalEquipment(equipmentId).getEquippedBodyParts().clear();

    }

    public void Potenzia(Equipment equipment, Titanite clientTitanite)
    {
        if(equipment.getEquippedTitaniti().size()<equipment.getUpgradesMax())
        {
            for (Titanite titan : this.personaggio.getTitaniti())
            {
                if(clientTitanite.getEquipmentType().EquipmentClass().isInstance(equipment)
                        && clientTitanite.getDiceColor() == titan.getDiceColor())
                {
                    equipment.addDice(titan.getDiceColor());
                    equipment.getEquippedTitaniti().add(titan);
                    titan.setAvailable(titan.getAvailable() - 1);
                    break;
                }
            }
        }
    }


    public void Depotenzia(Equipment equipment, Titanite clientTitanite)
    {
        Titanite tmp=null;
        for (Titanite titan : equipment.getEquippedTitaniti())
        {
            if (titan.getDiceColor() == clientTitanite.getDiceColor())
            {
                titan.setAvailable(titan.getAvailable() + 1);
                equipment.removeDice(titan.getDiceColor());
                tmp=titan;
            }
        }
        equipment.getEquippedTitaniti().remove(tmp);
    }

    private Equipment getLocalEquipment(int idEquipment){
        Equipment eq=null;
        for(Equipment equipment:this.personaggio.getZainoEquip()){
            if(equipment.getId()==idEquipment) {
                eq = equipment;
                break;
            }
        }
        return eq;
    }


    private List<BodyPart> getLocalBodyPartList(List<BodyPart> bodyParts){
        List<BodyPart> bodyPartList=new ArrayList<>();
        for (BodyPart bodyPart:bodyParts){
            for(BodyPart bodyPart1:this.personaggio.getBodyParts()){
                if(bodyPart.getName().equals(bodyPart1.getName()))
                    bodyPartList.add(bodyPart1);
            }
        }
        return  bodyPartList;
    }


}
