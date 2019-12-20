package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Personaggio.BodyPartType;
import javax.persistence.*;

@Entity
public class BodyPartRequirement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BodyPartType bodyPartType;

    private int numberBodyPart;

    public BodyPartType getBodyPartType() {
        return bodyPartType;
    }

    public int getNumberbodyPart() {
        return numberBodyPart;
    }
}
