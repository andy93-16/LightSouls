package com.eswproject.lightsouls.Domain.Artifacts;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="artefatto_type",discriminatorType = DiscriminatorType.STRING)
public abstract class Artefatto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}