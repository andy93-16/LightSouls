package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggio;
import java.util.ArrayList;
import java.util.List;

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
        if(((Personaggio)statoPersonaggio.getPersonaggioBase()).getZainoEquip().get(posE).getEquippedTitaniti().size()<
                ((Personaggio)statoPersonaggio.getPersonaggioBase()).getZainoEquip().get(posE).getUpgrades())
        {
            for (Titanite titan : ((Personaggio)statoPersonaggio.getPersonaggioBase()).getTitaniti())
            {
                if(clientTitanite.getEquipmentType().EquipmentClass().isInstance(((Personaggio)statoPersonaggio.getPersonaggioBase()).getZainoEquip().get(posE))
                        && clientTitanite.getDiceColor() == titan.getDiceColor())
                {
                    ((Personaggio)statoPersonaggio.getPersonaggioBase()).getZainoEquip().get(posE).getEquippedTitaniti().add(titan);
                    titan.setAvailable(titan.getAvailable() - 1);
                    break;
                }
            }
        }
    }


    public void Depotenzia(int posE, Titanite clientTitanite)
    {
        Titanite tmp=null;
        for (Titanite titan : ((Personaggio)statoPersonaggio.getPersonaggioBase()).getZainoEquip().get(posE).getEquippedTitaniti())
        {
            if (titan.getDiceColor() == clientTitanite.getDiceColor())
            {
                titan.setAvailable(titan.getAvailable() + 1);
                tmp=titan;
            }
        }
        ((Personaggio)statoPersonaggio.getPersonaggioBase()).getZainoEquip().get(posE).getEquippedTitaniti().remove(tmp);
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
