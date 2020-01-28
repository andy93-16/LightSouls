package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Domain.Stato.StatoPersonaggio;

import java.util.ArrayList;
import java.util.List;

public class GestoreEquipaggiamenti{

    public void setStatoPersonaggio(StatoPersonaggio statoPersonaggio) {
        this.statoPersonaggio = statoPersonaggio;
    }

    private StatoPersonaggio statoPersonaggio;

    public void Equipaggia(List<BodyPart> bodyParts, int posE){
        Equipment eqIn=((Personaggio)statoPersonaggio.getPersonaggioBase()).getZainoEquip().get(posE);
        List<BodyPart> bodyPartsSelected= getLocalBodyPartList(bodyParts);
        for(BodyPart bodyPart : bodyPartsSelected) {
            eqIn.getEquippedBodyParts().add(bodyPart);
            ((Personaggio)statoPersonaggio.getPersonaggioBase()).getBodyParts().remove(bodyPart);
        }
        statoPersonaggio.getEquipaggiati().add(eqIn);
        ((Personaggio)statoPersonaggio.getPersonaggioBase()).getZainoEquip().remove(eqIn);

    }

    public void Disequipaggia(int posE){
        Equipment eqOut=statoPersonaggio.getEquipaggiati().get(posE);
        for(BodyPart bodyPart : eqOut.getEquippedBodyParts()) {
            ((Personaggio)statoPersonaggio.getPersonaggioBase()).getBodyParts().add(bodyPart);

        }
        eqOut.getEquippedBodyParts().clear();
        statoPersonaggio.getEquipaggiati().remove(eqOut);
        ((Personaggio)statoPersonaggio.getPersonaggioBase()).getZainoEquip().add(eqOut);
    }

    public void Potenzia(String name, Titanite clientTitanite)
    {
        Personaggio player = (Personaggio) statoPersonaggio.getPersonaggioBase();
        Equipment requested_Equipment= findEquipment(name);
        if(requested_Equipment.getUpgrades() > 0 && clientTitanite.getAvailable() > 0 && clientTitanite.getAnime() <= player.getAnime())
        {
            for (Titanite player_Titanite : player.getTitaniti())
            {
                if(clientTitanite.getEquipmentType().EquipmentClass().isInstance(requested_Equipment)
                        && clientTitanite.getDiceColor() == player_Titanite.getDiceColor())
                {
                    player.setAnime( player.getAnime() - player_Titanite.getAnime());
                    player_Titanite.decrement_Available();
                    requested_Equipment.addTitanite(player_Titanite);
                    break;
                }
            }
        }
    }


    public void Depotenzia(String name, Titanite titanite_To_Remove)
    {
        Equipment requested_Equipment= findEquipment(name);
        Titanite tmp=null;
        for (Titanite forged_Titanite : requested_Equipment.getEquippedTitaniti())
        {
            if (forged_Titanite.getDiceColor() == titanite_To_Remove.getDiceColor())
            {
                forged_Titanite.increment_Available();
                tmp=forged_Titanite;
                break;
            }
        }
        requested_Equipment.removeTitanite(tmp);
    }

   /* private Equipment getLocalEquipmentInZaino(int idEquipment){
        Equipment eq=null;
        for(Equipment equipment:this.personaggio.getZainoEquip()){
            if(equipment.getId()==idEquipment) {
                eq = equipment;
                break;
            }
        }
        return eq;
    }

    public Equipment getLocalEquipmentInEquipaggiati(int idEquipment){
        Equipment eq=null;
        for(Equipment equipment:this.statistichePartitaPersonaggio.getEquipaggiati()) {
            if (equipment.getId() == idEquipment) {
                eq = equipment;
                break;
            }
        }
        return eq;
    }
*/
    private List<BodyPart> getLocalBodyPartList(List<BodyPart> bodyParts){
        List<BodyPart> bodyPartList=new ArrayList<>();
        for (BodyPart bodyPart:bodyParts){
            for(BodyPart personaggioBodyPart:((Personaggio)statoPersonaggio.getPersonaggioBase()).getBodyParts()){
                if(bodyPart.getName().equals(personaggioBodyPart.getName()))
                    bodyPartList.add(personaggioBodyPart);
            }
        }
        return  bodyPartList;
    }

    private Equipment findEquipment(String name)
    {
        List<Equipment> totalequipment= new ArrayList<>();
        totalequipment.addAll(this.statoPersonaggio.getEquipaggiati());
        totalequipment.addAll(((Personaggio)statoPersonaggio.getPersonaggioBase()).getZainoEquip());
        for (Equipment e: totalequipment)
        {
            if(e.getName().equals(name)) return e;
        }
        return null;
    }
}
