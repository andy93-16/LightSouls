package com.eswproject.lightsouls.Service;

import com.eswproject.lightsouls.Domain.Modalita;
import com.eswproject.lightsouls.Repository.modalitaRepository;

import java.util.Optional;

public class modalitaService implements modalitaRepository
{

    private static modalitaService single_instance = null;

    // static method to create instance of Singleton class
    public static modalitaService getInstance()
    {
        if (single_instance == null)
        {
            single_instance = new modalitaService();
        }

        return single_instance;
    }

    //@Override
    public Modalita findByName(String name) {
        return findByName(name);
    }

    @Override
    public <S extends Modalita> S save(S s)
    {
        return null;
    }

    @Override
    public <S extends Modalita> Iterable<S> saveAll(Iterable<S> iterable)
    {
        return null;
    }

    @Override
    public Optional<Modalita> findById(Long aLong)
    {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong)
    {
        return false;
    }

    @Override
    public Iterable<Modalita> findAll()
    {
        return null;
    }

    @Override
    public Iterable<Modalita> findAllById(Iterable<Long> iterable)
    {
        return null;
    }

    @Override
    public long count()
    {
        return 0;
    }

    @Override
    public void deleteById(Long aLong)
    {

    }

    @Override
    public void delete(Modalita modalita)
    {

    }

    @Override
    public void deleteAll(Iterable<? extends Modalita> iterable)
    {

    }

    @Override
    public void deleteAll()
    {

    }
}
