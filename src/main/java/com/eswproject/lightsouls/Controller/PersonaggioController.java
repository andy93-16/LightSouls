package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggio;
import com.eswproject.lightsouls.Domain.Personaggio.*;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Service.StatoPersonaggioBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class PersonaggioController {

    @Autowired
    private StatoPersonaggioBaseService statoPersonaggioBaseService;

    @Autowired
    private IncontroController incontroController;

    private GestoreEquipaggiamenti gestoreEquipaggiamenti=GestoreEquipaggiamenti.getInstance();

    private StatoPersonaggio statoPersonaggio;

    @GetMapping("/SetPersonaggio")
    public void SetPersonaggio() {
        statoPersonaggio = (StatoPersonaggio)statoPersonaggioBaseService.findById(1);
        statoPersonaggio.resetStato();
        gestoreEquipaggiamenti.setStatoPersonaggio(statoPersonaggio);
        incontroController.setStatoPersonaggio(statoPersonaggio);
    }

    @GetMapping("RiepilogoPersonaggio")
    public StatoPersonaggio getStatoPersonaggio(){
        return statoPersonaggio;
    }

	@PostMapping("/PotenziaEquipaggiamento/{name}")
	public String PotenziaEquipaggiamento(@PathVariable("name") String name,@RequestBody Titanite titanite)
    {
       this.gestoreEquipaggiamenti.Potenzia(name,titanite);
       return "/RiepilogoEquipaggiamenti";
    }

    @PostMapping("/DepotenziaEquipaggiamento/{name}")
    public String DepotenziaEquipaggiamento(@PathVariable("name") String name,@RequestBody Titanite titanite)
    {
        this.gestoreEquipaggiamenti.Depotenzia(name,titanite);
        return "/RiepilogoEquipaggiamenti";
    }

    @PostMapping("/Equipaggia/{posE}")
    public String Equipaggia(@RequestBody List<BodyPart> bodyParts,@PathVariable("posE") int posE)
    {   this.gestoreEquipaggiamenti.Equipaggia(bodyParts,posE);
        return "/EquipaggiaPersonaggio";
    }

    @GetMapping("/Disequipaggia/{posE}")
    public String Disequipaggia(@PathVariable("posE") int posE){
        this.gestoreEquipaggiamenti.Disequipaggia(posE);
        return "/EquipaggiaPersonaggio";
    }

}
