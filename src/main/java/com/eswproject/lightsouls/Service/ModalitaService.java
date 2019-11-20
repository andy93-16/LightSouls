package com.eswproject.lightsouls.Service;

import com.eswproject.lightsouls.Domain.Modalita;
import com.eswproject.lightsouls.Repository.ModalitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModalitaService
{
    @Autowired
    private ModalitaRepository mR;

    public Modalita findByName(String name) {
        return mR.findByName(name);
    }

}
