package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Controller.PersonaggioController;
import com.eswproject.lightsouls.Domain.Personaggio;

public abstract class StrategiaCambioEquipments {

    protected PersonaggioController pC;
    protected Personaggio p;

    public abstract void CambioEquipments(BodyPersonaggio EqOutPartName, int eqInPosition);

    public void RimuoviEquipment(BodyPersonaggio bp){
        this.p.getZainoEquip().add(this.p.getCurrentEquipped().get(bp));
        //TODO
        System.out.println(this.pC.geteS().findByName(bp.name()));
        this.p.getCurrentEquipped().replace(bp,this.pC.geteS().findByName(bp.getEqType()));
    }

    public void setpC(PersonaggioController pC) {
        this.pC = pC;
        this.p = pC.getPersonaggio();
    }
}
