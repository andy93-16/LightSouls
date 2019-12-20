package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Personaggio.BodyPart;
import java.util.List;
import java.util.Observable;

public class Equipment extends Observable {

    public DescrittoreEquipment getDescrittoreEquipment() {
        return descrittoreEquipment;
    }

    private DescrittoreEquipment descrittoreEquipment;

    private boolean used;

    private List<BodyPart> equippedBodyParts;

    public List<BodyPart> getEquippedBodyParts() {
        return equippedBodyParts;
    }


}
