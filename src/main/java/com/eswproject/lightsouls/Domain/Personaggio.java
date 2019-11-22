package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Domain.Artifacts.Artefatto;
import com.eswproject.lightsouls.Domain.Artifacts.ArtefattoEquip;
import com.eswproject.lightsouls.Domain.Artifacts.StatisticaBase;
import com.eswproject.lightsouls.Domain.Artifacts.StatisticaCombattimento;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class Personaggio {

	private List<Artefatto> artefatti;
	private StatisticaCombattimento statisticaCombattimento;
	private StatisticaBase statisticaBase;
	private int anime;

	@GetMapping("/RiepilogoEquipaggiabili")
	public List<Artefatto> RiepilogoEquipaggiabili() {
		ArrayList<Artefatto> equipaggiabili = new ArrayList<>();
		for (Artefatto artefatto : this.artefatti)
			if (artefatto instanceof ArtefattoEquip)
				equipaggiabili.add(artefatto);
		return equipaggiabili;
	}
}