package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Azione;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import javax.persistence.*;
import java.util.List;

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
