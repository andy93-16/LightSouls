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

    @Transient
    private Boolean equipped=false;

    public String getName() {
        return name;
    }

    public BodyPartType getBodyPartType() {
        return bodyPartType;
    }

    public Boolean getEquipped() {
        return equipped;
    }

    public void setEquipped(Boolean equipped) {
        this.equipped = equipped;
    }

}
