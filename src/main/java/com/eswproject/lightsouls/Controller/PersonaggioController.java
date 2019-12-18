package com.eswproject.lightsouls.Controller;


import com.eswproject.lightsouls.Domain.Combattimento.PersonaggioBase;
import com.eswproject.lightsouls.Domain.Personaggio.*;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Service.PersonaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class PersonaggioController extends PersonaggioBase {


    @Autowired
    PersonaggioService pS;

    private GestoreEquipaggiamenti gestoreEquipaggiamenti=GestoreEquipaggiamenti.getInstance();

    private DescrittorePersonaggio descrittorePersonaggio;

    @GetMapping("/SetPersonaggio")
    public void SetPersonaggio() {
        this.descrittorePersonaggio = pS.findById(1);
        this.gestoreEquipaggiamenti.setDescrittorePersonaggio(this.descrittorePersonaggio);
    }

    @GetMapping("RiepilogoPersonaggio")
    public DescrittorePersonaggio GetPersonaggio(){
        return this.descrittorePersonaggio;
    }


////////////POTENZIAMENTO EQUIPMENT///////////Dep
	@PostMapping("/PotenziaEquipaggiamento/{idE}")
	public String PotenziaEquipaggiamento(@PathVariable("idE")int idE,@RequestBody Titanite titanite)
    {   Equipment eq = null;
        for (Equipment equipment : this.descrittorePersonaggio.getZainoEquip())
        {
            if (equipment.getId() == idE)
            {
                eq = equipment;
                break;
            }
        }
       this.gestoreEquipaggiamenti.Potenzia(eq,titanite);
       return "/RiepilogoEquipaggiamenti";
    }

    @PostMapping("/DepotenziaEquipaggiamento/{idE}")
    public String DepotenziaEquipaggiamento(@PathVariable("idE")int idE,@RequestBody Titanite titanite)
    {   Equipment eq = null;
        for (Equipment equipment : this.descrittorePersonaggio.getZainoEquip())
        {
            if (equipment.getId() == idE)
            {
                eq = equipment;
                break;
            }
        }
        this.gestoreEquipaggiamenti.Depotenzia(eq,titanite);
        return "/RiepilogoEquipaggiamenti";
    }

    @GetMapping("/TitanitiForEquipment/{idE}")
    public List<Titanite> TitanitiForEquipment(@PathVariable("idE") int idE){
        List<Titanite> titanites= new ArrayList<>();
        Equipment eq = null;
        for (Equipment equipment : this.descrittorePersonaggio.getZainoEquip())
        {
            if (equipment.getId() == idE)
            {
                eq = equipment;
                break;
            }
        }
        for (Titanite titanite: this.descrittorePersonaggio.getTitaniti())
        {
            if (titanite.getEquipmentType().EquipmentClass().isInstance(eq))
                    titanites.add(titanite);
        }
        return titanites;
    }


////////////////////EQUIPMENT CHANGE///////////////////////

    @PostMapping("/Equipaggia/{IdEquipment}")
    public String Equipaggia(@RequestBody List<BodyPart> bodyParts,@PathVariable("IdEquipment") int idEquipment)
    {   this.gestoreEquipaggiamenti.Equipaggia(bodyParts,idEquipment);
        return "/EquipaggiaPersonaggio";
    }

    @GetMapping("/Disequipaggia/{IdEquipment}")
    public String Disequipaggia(@PathVariable("IdEquipment") int idEquipment){
        this.gestoreEquipaggiamenti.Disequipaggia(idEquipment);
        return "/EquipaggiaPersonaggio";
    }

}
