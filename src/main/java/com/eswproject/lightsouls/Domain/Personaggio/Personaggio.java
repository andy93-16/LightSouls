/*
package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.*;
import com.eswproject.lightsouls.Domain.Combattimento.PersonaggioBase;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.*;
import javax.persistence.*;

@Entity

public class Personaggio extends PersonaggioBase
{
	@OneToOne
	private StatisticheBase statisticheBase;

	private int anime;
	private int stamina;
	private int staminaRegen;

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

	public List<Equipment> getZainoEquip() {
		return this.zainoEquip;
	}

	public List<Titanite> getTitaniti() {
		return this.titaniti;
	}

	public void setStatisticaBase(StatisticheBase statisticaBase) {
		this.statisticheBase = statisticaBase;
	}

	public StatisticheBase getStatisticaBase() {
		return this.statisticheBase;
	}

	public int getAnime() {
		return anime;
	}

	public void setAnime(int anime) {
		this.anime = anime;
	}

}*/
