package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Artifacts.BodyPartRequirement;
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

    private Personaggio personaggio;

    GestoreEquipaggiamenti gestoreEquipaggiamenti;

    @GetMapping("/SetPersonaggio")
    public void SetPersonaggio() {
        this.personaggio=this.pS.findById(1);
        this.gestoreEquipaggiamenti=new GestoreEquipaggiamenti();
        this.gestoreEquipaggiamenti.setP(this.personaggio);
    }

////////////POTENZIAMENTO EQUIPMENT///////////

    @GetMapping("/RiepilogoEquipaggiamenti")
    public List<Equipment> RiepilogoEquipaggiamenti() {
        return this.personaggio.getZainoEquip();
    }

	@PostMapping("/PotenziaEquipaggiamento/{idE}")
	public String PotenziaEquipaggiamento(@PathVariable("idE")int idE,@RequestBody Titanite titanite)
    {   Equipment eq = null;
        for (Equipment equipment : this.personaggio.getZainoEquip())
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
        for (Equipment equipment : this.personaggio.getZainoEquip())
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
        for (Equipment equipment : this.personaggio.getZainoEquip())
        {
            if (equipment.getId() == idE)
            {
                eq = equipment;
                break;
            }
        }
        for (Titanite titanite: this.personaggio.getTitaniti())
        {
            if (titanite.getEquipmentType().EquipmentClass().isInstance(eq))
                    titanites.add(titanite);
        }
        return titanites;
    }

    @GetMapping("/TitanitiOfEquipment/{idE}")
    public List<Titanite> TitanitiOfEquipment(@PathVariable("idE") int idE){
        Equipment eq = null;
        for (Equipment equipment : this.personaggio.getZainoEquip())
        {
            if (equipment.getId() == idE)
            {
                eq = equipment;
                break;
            }
        }
        return eq.getEquippedTitaniti();
    }

////////////////////EQUIPMENT CHANGE///////////////////////

    @GetMapping("/RiepilogoEquipaggiabili")
    public List<Equipment> RiepilogoEquipaggiabili(){
        List<Equipment> equipaggiabili=new ArrayList<>();
        for(Equipment equipment : this.personaggio.getZainoEquip()) {
            BodyPartRequirement bodyPartRequirement = equipment.getBodyPartRequirement();
            if (BodyPartsForEquipment(equipment).size() >=
                    bodyPartRequirement.getNumberbodyPart()) {
                equipaggiabili.add(equipment);
            }
        }
        return equipaggiabili;
    }

    @GetMapping("/RiepilogoEquipaggiati")
    public List<Equipment> RiepilogoEquipaggiati(){
        List<Equipment> equipaggiabili=new ArrayList<>();
        for(Equipment equipment : this.personaggio.getZainoEquip()) {
            if(!equipment.getEquippedBodyParts().isEmpty())
                equipaggiabili.add(equipment);
        }
        return equipaggiabili;
    }

    @GetMapping("/RiepilogoNonEquipaggiabili")
    public List<Equipment> RiepilogoNonEquipaggiabili(){
        List<Equipment> nonEquipaggiabili=new ArrayList<>();
        for(Equipment equipment : this.personaggio.getZainoEquip()) {
            if (BodyPartsForEquipment(equipment).size() < equipment.getBodyPartRequirement().getNumberbodyPart()
               && equipment.getEquippedBodyParts().isEmpty())
                nonEquipaggiabili.add(equipment);
        }
        return nonEquipaggiabili;
    }

    @PostMapping("/BodyPartsForEquipment")
    public List<BodyPart> BodyPartsForEquipment(@RequestBody Equipment equipment){
        List<BodyPart> bodyPartsFiltered=new ArrayList<>();
        for (BodyPart bodyPart: this.personaggio.getBodyParts()) {
            if(!bodyPart.getEquipped() && bodyPart.getBodyPartType().
                    equals(equipment.getBodyPartRequirement().getBodyPartType()))
                bodyPartsFiltered.add(bodyPart);
        }
        return bodyPartsFiltered;
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
