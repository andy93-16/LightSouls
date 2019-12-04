package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.eswproject.lightsouls.Domain.Personaggio;
import com.eswproject.lightsouls.Service.PersonaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
		return personaggio.getZainoEquip();
    }

	@GetMapping("/PotenziaEquipaggiamento/{idE}&{idT}")
	public String PotenziaEquipaggiamento(@PathVariable("idE")int idE,@PathVariable("idT")DiceColor diceColor)
    {    Equipment eq = new Equipment();
        for (Equipment equipment : this.personaggio.getZainoEquip())
        {
            if (equipment.getId() == idE)
            {
                eq = equipment;
                break;
            }
        }

        if(eq.getUpgradesLeft()<=0) //No more upgradable
        {
            return "/RiepilogoEquipaggiamenti";
        }

        eq.setUpgradesLeft(eq.getUpgradesLeft()-1);
        eq.addDice(diceColor);
        for (Titanite titanite: this.personaggio.getTitaniti())
        {
            if (titanite.getSlotType()== eq.getSlotType() &  titanite.getDiceColor()==diceColor)
                titanite.setAvailable(titanite.getAvailable()-1);
        }
       return "/RiepilogoEquipaggiamenti";
    }

    @GetMapping("/DettagliEquipaggiamento/{id}")
    public List<Titanite> DettagliEquipaggiamento(@PathVariable(name="id")int id)
    {
        Equipment eq = new Equipment();
        for (Equipment equipment : this.personaggio.getZainoEquip())
        {
            if (equipment.getId() == id)
                eq = equipment;
        }
        List<Titanite> titanites= new ArrayList<>();
        for (Titanite titanite: this.personaggio.getTitaniti())
        {
            if (titanite.getSlotType()== eq.getSlotType())
            {
                titanites.add(titanite);
            }
        }
        return titanites;
    }


}
