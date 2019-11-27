package com.eswproject.lightsouls.Domain.Artifacts;

public enum AttaccoType
{
    FISICO("Fisico"),
    MAGICO("Magico");

    public final String label;

    private AttaccoType(String label)
    {
        this.label = label;
    }
}
