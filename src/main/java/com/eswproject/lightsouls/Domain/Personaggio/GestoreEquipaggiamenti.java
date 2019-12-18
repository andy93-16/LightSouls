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
        Equipment eqIn=getLocalEquipmentInZaino(equipmentId);
        List<BodyPart> bodyPartSelected=getLocalBodyPartList(bodyParts);
        for(BodyPart bodyPart :bodyPartSelected) {
            eqIn.getEquippedBodyParts().add(bodyPart);
            this.personaggio.getBodyParts().remove(bodyPart);
        }
        this.personaggio.getEquipaggiati().add(eqIn);
        this.personaggio.getZainoEquip().remove(eqIn);

    }

    public void Disequipaggia(int equipmentId){
        Equipment eqOut=getLocalEquipmentInEquipaggiati(equipmentId);
        for(BodyPart bodyPart : eqOut.getEquippedBodyParts()) {
            this.personaggio.getBodyParts().add(bodyPart);

        }
        eqOut.getEquippedBodyParts().clear();
        this.personaggio.getEquipaggiati().remove(eqOut);
        this.personaggio.getZainoEquip().add(eqOut);

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
                    equipment.addTitanite(titan);
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
                tmp=titan;
            }
        }
        equipment.removeTitanite(tmp);
    }

    private Equipment getLocalEquipmentInZaino(int idEquipment){
        Equipment eq=null;
        for(Equipment equipment:this.personaggio.getZainoEquip()){
            if(equipment.getId()==idEquipment) {
                eq = equipment;
                break;
            }
        }
        return eq;
    }

    private Equipment getLocalEquipmentInEquipaggiati(int idEquipment){
        Equipment eq=null;
        for(Equipment equipment:this.personaggio.getEquipaggiati()) {
            if (equipment.getId() == idEquipment) {
                eq = equipment;
                break;
            }
        }
        return eq;
    }


    private List<BodyPart> getLocalBodyPartList(List<BodyPart> bodyParts){
        List<BodyPart> bodyPartList=new ArrayList<>();
        for (BodyPart bodyPart:bodyParts){
            for(BodyPart personaggioBodyPart:this.personaggio.getBodyParts()){
                if(bodyPart.getName().equals(personaggioBodyPart.getName()))
                    bodyPartList.add(personaggioBodyPart);
            }
        }
        return  bodyPartList;
    }


}
