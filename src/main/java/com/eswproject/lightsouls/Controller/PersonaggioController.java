package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Artifacts.Artefatto;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Domain.Personaggio;
import com.eswproject.lightsouls.Service.PersonaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @GetMapping("/RiepilogoEquipaggiamenti")
    public List<Equipment> RiepilogoEquipaggiamenti() {
		ArrayList<Equipment> equipaggiamenti=new ArrayList<>();
		for (Artefatto artefatto : this.personaggio.getArtefatti()){
			if (artefatto instanceof Equipment)
				equipaggiamenti.add((Equipment) artefatto);}
				return equipaggiamenti;

    }
//
//	@PostMapping("/PotenziaEquipaggiamento")
//	public Equipment PotenziaEquipaggiamento(@RequestBody Equipment equipment){
//       System.out.println(equipment);
//       return equipment;
//    }

    @GetMapping("/DettagliEquipaggiamento/{id}")
    public List<Titanite> DettagliEquipaggiamento(@PathVariable(name="id")int id){
        Equipment eq = new Equipment();
        for (Artefatto artefatto : this.personaggio.getArtefatti()) {
            if (artefatto instanceof Equipment & artefatto.getId() == id)
                eq = (Equipment) artefatto;
        }
        ArrayList<Titanite> titanites= new ArrayList<>();
        for (Artefatto artefatto : this.personaggio.getArtefatti()) {
            if (artefatto instanceof Titanite & artefatto.getSlotType()== eq.getSlotType())
                titanites.add((Titanite)artefatto);
        }
        return titanites;
    }
}
