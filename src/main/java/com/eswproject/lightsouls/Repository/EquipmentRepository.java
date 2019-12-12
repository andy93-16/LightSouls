package com.eswproject.lightsouls.Repository;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment,Integer> {
    Equipment findById(int id);
    Equipment findByName(String name);
}
