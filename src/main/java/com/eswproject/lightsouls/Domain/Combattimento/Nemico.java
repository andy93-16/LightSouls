package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.Azione;

import java.util.List;

public class Nemico extends PersonaggioBase
{
    private List<Azione> azioni;

    public List<Azione> getAzioni()
    {
        return azioni;
    }

    public void setAzioni(List<Azione> azioni)
    {
        this.azioni = azioni;
    }
}
