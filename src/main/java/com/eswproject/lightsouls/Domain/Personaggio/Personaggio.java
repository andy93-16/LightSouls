package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Personaggio")
public class Personaggio extends PersonaggioBase
{
    private int stamina_base;

    private int anime;

    private int staminaRegen;

    private ClassName classe;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<BodyPart> bodyParts;

    @Embedded
    private StatisticheBase statisticheBase;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Titanite> titaniti;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Equipment> zainoEquip;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Equipment> lootable;

    public List<Equipment> getZainoEquip()
    {
        return this.zainoEquip;
    }

    public List<Titanite> getTitaniti()
    {
        return this.titaniti;
    }

    public int getStaminaRegen()
    {
        return staminaRegen;
    }

    public List<BodyPart> getBodyParts()
    {
        return this.bodyParts;
    }

    public StatisticheBase getStatisticaBase()
    {
        return this.statisticheBase;
    }

    public int getStamina_base()
    {
        return stamina_base;
    }

    public int getAnime()
    {
        return anime;
    }

    public ClassName getClasse()
    {
        return classe;
    }

    public List<Equipment> getLootable()
    {
        return lootable;
    }
}