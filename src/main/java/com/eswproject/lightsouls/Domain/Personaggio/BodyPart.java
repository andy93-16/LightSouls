package com.eswproject.lightsouls.Domain.Personaggio;

import javax.persistence.*;

@Entity
public class BodyPart {

    @Id
    private String name;

    private BodyPartType bodyPartType;

    public String getName() {
        return name;
    }

    public BodyPartType getBodyPartType() {
        return bodyPartType;
    }


}
