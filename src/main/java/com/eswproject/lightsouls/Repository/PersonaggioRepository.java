package com.eswproject.lightsouls.Repository;

import com.eswproject.lightsouls.Controller.PersonaggioController;
import com.eswproject.lightsouls.Domain.Personaggio.DescrittorePersonaggio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaggioRepository extends CrudRepository<DescrittorePersonaggio,Integer>
{
    DescrittorePersonaggio findById(int id);
}
