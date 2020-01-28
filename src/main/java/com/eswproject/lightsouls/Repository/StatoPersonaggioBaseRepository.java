package com.eswproject.lightsouls.Repository;

import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggioBase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoPersonaggioBaseRepository extends CrudRepository< StatoPersonaggioBase,Integer>
{
    StatoPersonaggioBase findById(int id);
}
