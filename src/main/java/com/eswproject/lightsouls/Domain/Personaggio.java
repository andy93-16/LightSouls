package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Domain.Artifacts.Artefatto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.eswproject.lightsouls.Domain.Artifacts.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class Personaggio {

	private List<Artefatto> artefatti;
	private StatisticaBase statisticaBase;
	private int anime;

	@GetMapping("/RiepilogoEquipaggiabili")
	public List<Artefatto> RiepilogoEquipaggiabili() {
		ArrayList<Artefatto> equipaggiabili = new ArrayList<>();
		for (Artefatto artefatto : this.artefatti)
			if (artefatto instanceof Equipment)
				equipaggiabili.add(artefatto);
		return equipaggiabili;
	}

	@GetMapping("/PotenziaOggetto")
	public String PotenziaOggetto() {
		// TODO - implement Personaggio.PotenziaOggetto
		throw new UnsupportedOperationException();
	}
}