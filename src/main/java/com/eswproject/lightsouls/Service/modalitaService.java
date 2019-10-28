package com.eswproject.lightsouls.Service;

import com.eswproject.lightsouls.Domain.Modalita;
import com.eswproject.lightsouls.Repository.modalitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class modalitaService
{
    @Autowired
    private modalitaRepository mR;

    public Modalita findByName(String name) {

        System.out.println("Nome = " + name);
        System.out.println("Trovato = " + mR.findByName(name).getName());
        return mR.findByName(name);
    }

}
