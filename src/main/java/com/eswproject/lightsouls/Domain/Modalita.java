package com.eswproject.lightsouls.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Modalita
{

    @Id
    String name;

    public String getName()
    {
        return name;
    }
}