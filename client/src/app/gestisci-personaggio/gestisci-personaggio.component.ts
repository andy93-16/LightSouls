import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-gestisci-personaggio',
  templateUrl: './gestisci-personaggio.component.html',
  styleUrls: ['./gestisci-personaggio.component.css']
})
export class GestisciPersonaggioComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  PotenziaEquipaggiamento(): void {
    this.router.navigate(['/RiepilogoEquipaggiamenti']);
  }

  CambiaEquipaggiamento(): void {
  }

  TornaAlFalo():void {
    this.router.navigate(['/Falo']);
  }
}
