package com.eswproject.lightsouls.Controller;



import com.eswproject.lightsouls.Domain.Personaggio.*;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Service.PersonaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class PersonaggioController {


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
    public DescrittorePersonaggio getDescrittorePersonaggio(){
        return this.descrittorePersonaggio;
    }

	@PostMapping("/PotenziaEquipaggiamento/{idE}")
	public String PotenziaEquipaggiamento(@PathVariable("idE")int idE,@RequestBody Titanite titanite)
    {
       this.gestoreEquipaggiamenti.Potenzia(getLocalEquipment(idE),titanite);
       return "/RiepilogoEquipaggiamenti";
    }

    @PostMapping("/DepotenziaEquipaggiamento/{idE}")
    public String DepotenziaEquipaggiamento(@PathVariable("idE")int idE,@RequestBody Titanite titanite)
    {
        this.gestoreEquipaggiamenti.Depotenzia(getLocalEquipment(idE),titanite);
        return "/RiepilogoEquipaggiamenti";
    }

    private Equipment getLocalEquipment(int idE){
        Equipment eq = null;
        for (Equipment equipment : this.descrittorePersonaggio.getZainoEquip())
        {
            if (equipment.getId() == idE)
            {
                eq = equipment;
                break;
            }
        }
        return eq;
    }


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
