package com.eswproject.lightsouls.Domain.Artifacts;


public class CambioArmatura extends StrategiaCambioEquipments {
    @Override
    public void CambioEquipments(BodyPersonaggio EqOutPartName, int eqInPosition){
        Armatura tmp = (Armatura) p.getCurrentEquipped().get(EqOutPartName);
        p.getCurrentEquipped().replace(EqOutPartName,p.getZainoEquip().get(eqInPosition));
        p.getZainoEquip().set(eqInPosition,tmp);
    }

}
