import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {RouterEvoService} from "../router-evo.service";

@Component({
  selector: 'app-gestisci-personaggio',
  templateUrl: './gestisci-personaggio.component.html',
  styleUrls: ['./gestisci-personaggio.component.css']
})
export class GestisciPersonaggioComponent implements OnInit {

  constructor(private routerEvo: RouterEvoService) { }

  ngOnInit() {
  }

  PotenziaEquipaggiamento(): void {
    this.routerEvo.navigate(['/RiepilogoEquipaggiamenti']);
  }

  CambiaEquipaggiamento(): void {
    this.routerEvo.navigate(['/CambiaEquipaggiamento']);
  }

  TornaAlFalo(): void {
    this.routerEvo.navigate(['/Falo']);
  }
}
