package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;


import java.util.ArrayList;
import java.util.List;

public class GestoreEquipaggiamenti{

    private DescrittorePersonaggio descrittorePersonaggio;

    public DescrittorePersonaggio getDescrittorePersonaggio() {
        return descrittorePersonaggio;
    }

    public void setDescrittorePersonaggio(DescrittorePersonaggio descrittorePersonaggio) {
        this.descrittorePersonaggio = descrittorePersonaggio;
    }

    private static GestoreEquipaggiamenti obj;

    private GestoreEquipaggiamenti() {}

    public static GestoreEquipaggiamenti getInstance()
    {
        if (obj==null)
            obj = new GestoreEquipaggiamenti();
        return obj;
    }

    public void Equipaggia(List<BodyPart> bodyParts, int equipmentId){
        Equipment eqIn=getLocalEquipmentInZaino(equipmentId);
        List<BodyPart> bodyPartSelected=getLocalBodyPartList(bodyParts);
        for(BodyPart bodyPart :bodyPartSelected) {
            eqIn.getEquippedBodyParts().add(bodyPart);
            this.descrittorePersonaggio.getBodyParts().remove(bodyPart);
        }
        this.descrittorePersonaggio.getEquipaggiati().add(eqIn);
        this.descrittorePersonaggio.getZainoEquip().remove(eqIn);

    }

    public void Disequipaggia(int equipmentId){
        Equipment eqOut=getLocalEquipmentInEquipaggiati(equipmentId);
        for(BodyPart bodyPart : eqOut.getEquippedBodyParts()) {
            this.descrittorePersonaggio.getBodyParts().add(bodyPart);

        }
        eqOut.getEquippedBodyParts().clear();
        this.descrittorePersonaggio.getEquipaggiati().remove(eqOut);
        this.descrittorePersonaggio.getZainoEquip().add(eqOut);

    }

    public void Potenzia(Equipment equipment, Titanite clientTitanite)
    {
        if(equipment.getEquippedTitaniti().size()<equipment.getUpgradesMax())
        {
            for (Titanite titan : this.descrittorePersonaggio.getTitaniti())
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
        for(Equipment equipment:this.descrittorePersonaggio.getZainoEquip()){
            if(equipment.getId()==idEquipment) {
                eq = equipment;
                break;
            }
        }
        return eq;
    }

    private Equipment getLocalEquipmentInEquipaggiati(int idEquipment){
        Equipment eq=null;
        for(Equipment equipment:this.descrittorePersonaggio.getEquipaggiati()) {
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
            for(BodyPart personaggioBodyPart:this.descrittorePersonaggio.getBodyParts()){
                if(bodyPart.getName().equals(personaggioBodyPart.getName()))
                    bodyPartList.add(personaggioBodyPart);
            }
        }
        return  bodyPartList;
    }


}
