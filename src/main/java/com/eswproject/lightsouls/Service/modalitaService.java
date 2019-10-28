package com.eswproject.lightsouls.Service;

import com.eswproject.lightsouls.Domain.Modalita;
import com.eswproject.lightsouls.Repository.modalitaRepository;

public class modalitaService implements modalitaRepository {

    private static modalitaService single_instance = null;

    // static method to create instance of Singleton class
    public static modalitaService getInstance()
    {
        if (single_instance == null)
            single_instance = new modalitaService();

        return single_instance;
    }

    @Override
    public Modalita findByName(String name) {
        return findByName(name);
    }

    @Override
    public void save(Modalita m){

    }
}
