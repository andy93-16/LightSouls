package com.eswproject.lightsouls.Repository;


import com.eswproject.lightsouls.Domain.Modalita;
import org.springframework.data.repository.CrudRepository;


public interface modalitaRepository extends CrudRepository<Modalita, Long>
{
    //public Modalita findByName(String name);
}