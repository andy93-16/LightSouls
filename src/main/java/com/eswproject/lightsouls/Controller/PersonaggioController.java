package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Artifacts.Artefatto;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Personaggio;
import com.eswproject.lightsouls.Service.PersonaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
public class PersonaggioController {

    @Autowired
    PersonaggioService pS;

    Personaggio personaggio;

    @GetMapping("/SetPersonaggio")
    public void SetPersonaggio() {
        personaggio=this.pS.findById(1);
    }

    @GetMapping("/RiepilogoEquipaggiabili")
    public List<Equipment> RiepilogoEquipaggiabili() {
		ArrayList<Equipment> equipaggiabili=new ArrayList<>();
		for (Artefatto artefatto : this.personaggio.getArtefatti()){
			if (artefatto instanceof Equipment)
				equipaggiabili.add((Equipment) artefatto);}
				return equipaggiabili;

    }

//	@GetMapping("/PotenziaOggetto")
//	public String PotenziaOggetto() {
//		// TODO - implement Personaggio.PotenziaOggetto
//		throw new UnsupportedOperationException();
//	}

}
