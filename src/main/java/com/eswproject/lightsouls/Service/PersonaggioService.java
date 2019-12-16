package com.eswproject.lightsouls.Service;

import com.eswproject.lightsouls.Domain.Personaggio.Personaggio;
import com.eswproject.lightsouls.Repository.PersonaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaggioService {

    @Autowired
    private PersonaggioRepository pR;

    public Personaggio findById(int id)   {
        return pR.findById(id);
    }

}
