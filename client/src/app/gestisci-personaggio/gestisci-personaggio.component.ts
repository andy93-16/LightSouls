import { Component, OnInit } from '@angular/core';
import {RouterService} from "../router.service";

@Component({
  selector: 'app-gestisci-personaggio',
  templateUrl: './gestisci-personaggio.component.html',
  styleUrls: ['./gestisci-personaggio.component.css']
})
export class GestisciPersonaggioComponent implements OnInit {

  constructor(private routerService: RouterService) { }

  ngOnInit() {
  }

  PotenziaEquipaggiamento(): void {
    this.routerService.RouteTo(['/RiepilogoEquipaggiamenti']);
  }

  CambiaEquipaggiamento(): void {
  }
}
