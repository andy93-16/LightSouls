package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;

import java.util.ArrayList;
import java.util.List;

public class Loot {

    private List<Equipment> equipments= new ArrayList<>();

    private List<Titanite> titanites= new ArrayList<>();

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<Titanite> getTitanites() {
        return titanites;
    }

    public void setTitanites(List<Titanite> titanites) {
        this.titanites = titanites;
    }
}
