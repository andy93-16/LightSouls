package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Domain.Combattimento.Loot;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Personaggio")
public class Personaggio extends PersonaggioBase
{
    private int stamina_base;

    private int anime;

    private int staminaRegen;

    private int rollCost;

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

    public int getRollCost() {
        return rollCost;
    }

    public List<Equipment> getLootable()
    {
        return lootable;
    }

    public void setAnime(int anime) {
        this.anime = anime;
    }

    public List<Titanite> getLootableTitanites()
    {
        List<Titanite> lootabletitanites=new ArrayList<>();
        for (Titanite t: this.getTitaniti()) {
            if(t.getLooted()<t.getMaxlootable())
            {
                lootabletitanites.add(t);
            }
        }
        return lootabletitanites;
    }

    public void aggiungiLoot(Loot loot)
    {
        this.setAnime(this.getAnime() + loot.getAnime());
        this.getZainoEquip().addAll(loot.getEquipments());
        this.getLootable().removeAll(loot.getEquipments());

        for (Titanite titaniteloot: loot.getTitanites())
        {
            for (Titanite titan : this.titaniti)
            {
                if(titaniteloot.getEquipmentType()==titan.getEquipmentType()
                        && titaniteloot.getDiceColor() == titan.getDiceColor())
                {
                    titan.setLooted(titan.getLooted()+1);
                    titan.setAvailable(titan.getAvailable()+1);
                    break;
                }
            }
        }
    }
}