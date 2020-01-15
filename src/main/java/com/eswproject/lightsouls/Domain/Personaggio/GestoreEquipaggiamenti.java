package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Arma;
import com.eswproject.lightsouls.Domain.Artifacts.Azione.Attacco;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggio;
import com.eswproject.lightsouls.Domain.Dice.DiceColor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GestoreEquipaggiamenti{

    public void setStatoPersonaggio(StatoPersonaggio statoPersonaggio) {
        this.statoPersonaggio = statoPersonaggio;
    }

    private StatoPersonaggio statoPersonaggio;

    private static GestoreEquipaggiamenti obj;

    private GestoreEquipaggiamenti() {}

    public static GestoreEquipaggiamenti getInstance()
    {
        if (obj==null)
            obj = new GestoreEquipaggiamenti();
        return obj;
    }

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

    public void Potenzia(int posE, Titanite clientTitanite)
    {
        Personaggio player = (Personaggio) statoPersonaggio.getPersonaggioBase();
        Equipment requested_Equipment = player.getZainoEquip().get(posE);

        if(requested_Equipment.getEquippedTitaniti().size() < requested_Equipment.getUpgrades())
        {
            for (Titanite player_Titanite : player.getTitaniti())
            {
                if(clientTitanite.getEquipmentType().EquipmentClass().isInstance(requested_Equipment)
                        && clientTitanite.getDiceColor() == player_Titanite.getDiceColor())
                {
                    player_Titanite.decrement_Available();
                    requested_Equipment.addTitanite(player_Titanite);
                    break;
                }
            }
        }
    }


    public void Depotenzia(int posE, Titanite titanite_To_Remove)
    {
        Equipment requested_Equipment = ((Personaggio)statoPersonaggio.getPersonaggioBase()).getZainoEquip().get(posE);
        System.out.println("lunghezza titaniti equipaggiate = " + requested_Equipment.getEquippedTitaniti().size());
        for(Titanite t : requested_Equipment.getEquippedTitaniti())
        {
            System.out.println("Titanite equipaggiata sull'oggetto = " + t.getDiceColor().toString());
        }
        for (Titanite forged_Titanite : requested_Equipment.getEquippedTitaniti())
        {
            if (forged_Titanite.getDiceColor() == titanite_To_Remove.getDiceColor())
            {
                forged_Titanite.increment_Available();
                requested_Equipment.removeTitanite(forged_Titanite);
            }
        }

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
}
