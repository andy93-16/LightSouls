package com.eswproject.lightsouls.Domain.Artifacts;

import org.hibernate.annotations.Entity;

@Entity
public enum ActionType
{
    FISICO("Fisico"),
    MAGICO("Magico");


    public final String label;

    private ActionType(String label)
    {
        this.label = label;
    }
}
