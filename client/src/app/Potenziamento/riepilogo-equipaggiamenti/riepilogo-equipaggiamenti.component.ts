import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../http.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-riepilogo-equipaggiamenti',
  templateUrl: './riepilogo-equipaggiamenti.component.html',
  styleUrls: ['./riepilogo-equipaggiamenti.component.css']
})
export class RiepilogoEquipaggiamentiComponent implements OnInit {

  statoPersonaggio: any;
  equipaggiamenti: any[] = [];

  constructor(private httpservice: HttpService, private router: Router) {
    this.httpservice.RiepilogoPersonaggio().subscribe(statoPersonaggio => {
      this.statoPersonaggio = statoPersonaggio;
      this.equipaggiamenti = this.equipaggiamenti.concat(this.statoPersonaggio.personaggioBase.zainoEquip);
      });
  }

  ngOnInit() {
  }

  TitanitiForEquipment(equipaggiamento: any): any[] {
    const titaniti: any[] = [];
    this.statoPersonaggio.personaggioBase.titaniti.forEach( titanite => {
      if (titanite.equipmentType === equipaggiamento.type) {
            titaniti.push(titanite);
      }
    });
    return titaniti;
  }

  DettagliPotenziamento(equipaggiamento: any): void {
    this.router.navigate(['/DettagliPotenziamento'], { state: {
      equipaggiamentoPos:this.statoPersonaggio.personaggioBase.zainoEquip.indexOf(equipaggiamento),
      equipaggiamentoSelezionato : equipaggiamento,
      titanitiForEquipment : this.TitanitiForEquipment(equipaggiamento)}});
  }

  DettagliDepotenziamento(equipaggiamento: any): void {
    this.router.navigate(['/DettagliDepotenziamento'], {
      state:{
      equipaggiamentoPos:this.statoPersonaggio.personaggioBase.zainoEquip.indexOf(equipaggiamento),
      equipaggiamentoSelezionato : equipaggiamento}});
  }

  TornaGestisciPersonaggio(): void {
    this.router.navigate(['/GestisciPersonaggio']);
  }
}
