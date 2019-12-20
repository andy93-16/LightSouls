package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Domain.Combattimento.StatisticheCombattimentoPersonaggio;


import java.util.ArrayList;
import java.util.List;

public class GestoreEquipaggiamenti{

    public void setStatisticheCombattimentoPersonaggio(StatisticheCombattimentoPersonaggio statisticheCombattimentoPersonaggio) {
        this.statisticheCombattimentoPersonaggio = statisticheCombattimentoPersonaggio;
    }

    private StatisticheCombattimentoPersonaggio statisticheCombattimentoPersonaggio;

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

            this.statisticheCombattimentoPersonaggio.getDescrittorePersonaggioBase().getBodyParts().remove(bodyPart);
        }
        this.statisticheCombattimentoPersonaggio.getEquipaggiati().add(eqIn);
        this.statisticheCombattimentoPersonaggio.getDescrittorePersonaggioBase().getZainoEquip().remove(eqIn);

    }

    public void Disequipaggia(int equipmentId){
        Equipment eqOut=getLocalEquipmentInEquipaggiati(equipmentId);
        for(BodyPart bodyPart : eqOut.getEquippedBodyParts()) {
            this.statisticheCombattimentoPersonaggio.getDescrittorePersonaggioBase().getBodyParts().add(bodyPart);

        }
        eqOut.getEquippedBodyParts().clear();
        this.statisticheCombattimentoPersonaggio.getEquipaggiati().remove(eqOut);
        this.statisticheCombattimentoPersonaggio.getDescrittorePersonaggioBase().getZainoEquip().add(eqOut);

    }

    public void Potenzia(Equipment equipment, Titanite clientTitanite)
    {
        if(equipment.getEquippedTitaniti().size()<equipment.getDescrittoreEquipment().getUpgradesMax())
        {
            for (Titanite titan : this.statisticheCombattimentoPersonaggio.getDescrittorePersonaggioBase().getTitaniti())
            {
                if(clientTitanite.getEquipmentType().EquipmentClass().isInstance(equipment)
                        && clientTitanite.getDiceColor() == titan.getDiceColor())
                {
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
                tmp=titan;
            }
        }
        equipment.getEquippedTitaniti().remove(tmp);
    }

    private Equipment getLocalEquipmentInZaino(int idEquipment){
        Equipment eq=null;
        for(Equipment equipment:this.statisticheCombattimentoPersonaggio.getDescrittorePersonaggioBase().getZainoEquip()){
            if(equipment.getId()==idEquipment) {
                eq = equipment;
                break;
            }
        }
        return eq;
    }

    public Equipment getLocalEquipmentInEquipaggiati(int idEquipment){
        Equipment eq=null;
        for(Equipment equipment:this.statisticheCombattimentoPersonaggio.getEquipaggiati()) {
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
            for(BodyPart personaggioBodyPart:statisticheCombattimentoPersonaggio.getDescrittorePersonaggioBase().getBodyParts()){
                if(bodyPart.getName().equals(personaggioBodyPart.getName()))
                    bodyPartList.add(personaggioBodyPart);
            }
        }
        return  bodyPartList;
    }


}
