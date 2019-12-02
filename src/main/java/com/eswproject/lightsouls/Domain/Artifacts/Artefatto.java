package com.eswproject.lightsouls.Domain.Artifacts;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="artefatto_type",discriminatorType = DiscriminatorType.STRING)
public abstract class Artefatto {

    public int getId() {
        return id;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    private SlotType slotType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}

enum SlotType{

    ARMA,
    ARMATURA;

}
