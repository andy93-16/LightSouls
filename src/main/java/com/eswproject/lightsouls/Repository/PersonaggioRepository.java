package com.eswproject.lightsouls.Repository;

import com.eswproject.lightsouls.Domain.Personaggio.Personaggio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaggioRepository extends CrudRepository<Personaggio,Integer>
{
    Personaggio findById(int id);
}
