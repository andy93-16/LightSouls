package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Domain.Artifacts.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.*;
import javax.persistence.*;


@Entity
public class Personaggio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private StatisticaBase statisticaBase;

	@Transient
	private int anime = 0;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Titanite> titaniti;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Equipment> zainoEquip;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name="body_personaggio")
    @Fetch(FetchMode.SUBSELECT)
    private Map<BodyPersonaggio,Equipment> equippedEquipments;

    public Map<BodyPersonaggio, Equipment> getEquippedEquipments() {
        return equippedEquipments;
    }

    public int getId() {
        return id;
    }

	public List<Equipment> getZainoEquip() {
		return this.zainoEquip;
	}

	public List<Titanite> getTitaniti() {
		return this.titaniti;
	}

	public void setStatisticaBase(StatisticaBase statisticaBase) {
		this.statisticaBase = statisticaBase;
	}

	public StatisticaBase getStatisticaBase() {
		return this.statisticaBase;
	}

	public int getAnime() {
		return anime;
	}

	public void setAnime(int anime) {
		this.anime = anime;
	}

}