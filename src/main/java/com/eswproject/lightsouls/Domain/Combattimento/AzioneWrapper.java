package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.Azione;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;

public class AzioneWrapper {
    public Equipment getEquipment() {
        return equipment;
    }

    public Azione getAzione() {
        return azione;
    }

    Equipment equipment;
    Azione azione;

}
