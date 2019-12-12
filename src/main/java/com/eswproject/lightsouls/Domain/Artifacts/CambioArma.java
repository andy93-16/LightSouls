package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Personaggio;

public class CambioArma extends StrategiaCambioEquipments
{
    //TODO
    @Override
    public void CambioEquipments(BodyPersonaggio EqOutPartName, int eqInPosition){
        Personaggio p=this.pC.getPersonaggio();
        Arma armaTmp = (Arma) p.getCurrentEquipped().get(EqOutPartName);
        Arma armaIn = (Arma) p.getZainoEquip().get(eqInPosition);
        System.out.println(p.getZainoEquip().size());

        //Prendi una lista di armi equipaggiate
        if(armaIn.getWeight()<2)
        {
            if(p.getCurrentEquipped().get(EqOutPartName).getWeight()==2){
                for(BodyPersonaggio bp: p.getCurrentEquipped().keySet()){
                    if(p.getCurrentEquipped().get(bp)==null)
                    {
                        Equipment pugno=null;
                        int pugnoPosition=0;
                        for(int i=0;i<p.getZainoEquip().size();i++)
                        {
                            if (bp.name() == p.getZainoEquip().get(i).getName())
                            {
                                pugno = p.getZainoEquip().get(i);
                                pugnoPosition = i;
                            }
                        }
                        p.getCurrentEquipped().replace(bp,pugno);
                        p.getZainoEquip().remove(pugnoPosition);
                    }
                }
            }
            p.getCurrentEquipped().replace(EqOutPartName,null);
        }
        else //weight == 2
        {
            for(BodyPersonaggio bp : p.getCurrentEquipped().keySet()) {
                if (bp.getEqType() == "Arma") {
                    p.getZainoEquip().add(p.getCurrentEquipped().get(bp));
                    p.getCurrentEquipped().replace(bp, null);
                }
            }

        }
        p.getCurrentEquipped().put(EqOutPartName,armaIn);
        p.getZainoEquip().set(eqInPosition,armaTmp);
        System.out.println(p.getZainoEquip().size());
    }

}
