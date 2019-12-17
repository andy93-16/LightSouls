package com.eswproject.lightsouls.Domain.Personaggio;

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

	private int anime;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Titanite> titaniti;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Equipment> zainoEquip;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<BodyPart> bodyParts;

    public List<BodyPart> getBodyParts() {
        return this.bodyParts;
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