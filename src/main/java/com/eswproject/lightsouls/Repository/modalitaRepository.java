package com.eswproject.lightsouls.Repository;


import com.eswproject.lightsouls.Domain.Modalita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface modalitaRepository extends CrudRepository<Modalita, String>
{
    public Modalita findByName(String name);

}