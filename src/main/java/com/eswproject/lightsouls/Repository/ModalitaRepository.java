package com.eswproject.lightsouls.Repository;


import com.eswproject.lightsouls.Domain.Partita.Modalita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalitaRepository extends CrudRepository<Modalita, String>
{
    Modalita findByName(String name);
}