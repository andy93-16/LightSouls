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

  DettagliPotenziamento(equipaggiamento: any): void {
    this.router.navigate(['/DettagliPotenziamento',
      this.statoPersonaggio.personaggioBase.zainoEquip.indexOf(equipaggiamento)], { skipLocationChange: true , state: {
      equipaggiamentoSelezionato : equipaggiamento,
      }});
  }

  DettagliDepotenziamento(equipaggiamento: any): void {
    this.router.navigate(['/DettagliDepotenziamento',
      this.statoPersonaggio.personaggioBase.zainoEquip.indexOf(equipaggiamento)],
      {skipLocationChange: true,   state:{
      equipaggiamentoSelezionato : equipaggiamento}});
  }

  TornaGestisciPersonaggio(): void {
    this.router.navigate(['/GestisciPersonaggio']);
  }
}
