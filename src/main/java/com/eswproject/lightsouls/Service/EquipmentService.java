package com.eswproject.lightsouls.Service;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository eR;

    public Equipment findById(int id){
        return this.eR.findById(id);
    }
    public Equipment findByName(String name){
        return this.eR.findByName(name);
    }

}
