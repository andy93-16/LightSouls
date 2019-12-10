package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Artifacts.BodyPersonaggio;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.eswproject.lightsouls.Domain.Personaggio;
import com.eswproject.lightsouls.Service.PersonaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
        List<Equipment> equipaggiamenti= new ArrayList<>();
        equipaggiamenti.addAll(personaggio.getZainoEquip());
        equipaggiamenti.addAll(personaggio.getCurrentEquipped().values());
		return equipaggiamenti;
    }

	@GetMapping("/PotenziaEquipaggiamento/{idE}&{idT}")
	public String PotenziaEquipaggiamento(@PathVariable("idE")int idE,@PathVariable("idT")DiceColor diceColor)
    {   Equipment eq = null;
        for (Equipment equipment : this.personaggio.getZainoEquip())
        {
            if (equipment.getId() == idE)
            {
                eq = equipment;
                break;
            }
        }
        if(eq.getUpgradesLeft()>0) //No more upgradable
        {
            eq.setUpgradesLeft(eq.getUpgradesLeft() - 1);
            eq.addDice(diceColor);
            for (Titanite titanite : this.personaggio.getTitaniti()) {
                if (titanite.getEquipmentType().EquipmentClass().isInstance(eq) & titanite.getDiceColor() == diceColor)
                    titanite.setAvailable(titanite.getAvailable() - 1);
            }
        }
       return "/RiepilogoEquipaggiamenti";
    }

    @GetMapping("/DettagliEquipaggiamento/{id}")
    public List<Titanite> DettagliEquipaggiamento(@PathVariable(name="id")int id){
        Equipment eq=null;
        for (Equipment equipment : this.personaggio.getZainoEquip())
        {
            if (equipment.getId() == id) {
                eq = equipment;
                break;
            }
        }
        List<Titanite> titanites= new ArrayList<>();
        for (Titanite titanite: this.personaggio.getTitaniti())
        {
            if (titanite.getEquipmentType().EquipmentClass().isInstance(eq))
                    titanites.add(titanite);
        }
        return titanites;
    }

    @GetMapping("/RiepilogoEquipaggiati")
    public Map<BodyPersonaggio,Equipment> RiepilogoEquipaggiati(){
        return this.personaggio.getCurrentEquipped();
    }

    @GetMapping("/RiepilogoEquipaggiabili/{id}")
    public List<Equipment> RiepilogoEquipaggiabili(@PathVariable(name="id")int id){
        Equipment eq=null;
        for(Equipment equipment: this.personaggio.getCurrentEquipped().values())
        {
            if(equipment.getId()==id) {
                eq = equipment;
                break;
            }
        }
        List<Equipment> equipaggiabili=new ArrayList<>();
        for(Equipment equipment: this.personaggio.getZainoEquip())
        {
            if(equipment.getClass()==eq.getClass())
                equipaggiabili.add(equipment);
        }
        return equipaggiabili;
    }
    @GetMapping("/Scambia/{idOut}&{idIn}")
    public String Scambia(@PathVariable("idOut")int idOut,@PathVariable("idIn")int idIn){
       
       return "/CambiaEquipaggiamento";
    }
}
