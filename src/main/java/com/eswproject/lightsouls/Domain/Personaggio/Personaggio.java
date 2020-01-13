package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Personaggio")
public class Personaggio extends PersonaggioBase {

    private int stamina_base;

    public int getAnime() {
        return anime;
    }

    private int anime;

    public int getStamina_base()
    {
        return stamina_base;
    }


    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Titanite> titaniti;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Equipment> zainoEquip;

    public List<Equipment> getZainoEquip() {
        return this.zainoEquip;
    }

    public List<Titanite> getTitaniti() {
        return this.titaniti;
    }

    @Embedded
    private StatisticheBase statisticheBase;

    public int getStaminaRegen() {
        return staminaRegen;
    }

    private int staminaRegen;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<BodyPart> bodyParts;

    public List<BodyPart> getBodyParts() {
        return this.bodyParts;
    }

    public StatisticheBase getStatisticaBase() {
        return this.statisticheBase;
    }

}

