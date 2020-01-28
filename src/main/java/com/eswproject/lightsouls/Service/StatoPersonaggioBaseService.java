package com.eswproject.lightsouls.Service;

import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggioBase;
import com.eswproject.lightsouls.Repository.StatoPersonaggioBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatoPersonaggioBaseService {

    @Autowired
    private StatoPersonaggioBaseRepository pR;

    public StatoPersonaggioBase findById(int id)   {
        return pR.findById(id);
    }

}
