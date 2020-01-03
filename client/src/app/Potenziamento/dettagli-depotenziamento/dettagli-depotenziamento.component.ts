import { Component, OnInit } from '@angular/core';
import {HttpService} from "../../http.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-dettagli-depotenziamento',
  templateUrl: './dettagli-depotenziamento.component.html',
  styleUrls: ['./dettagli-depotenziamento.component.css']
})
export class DettagliDepotenziamentoComponent implements OnInit {
  equipaggiamento: any;
  equipaggiamentoPos: number;

  constructor(private httpservice: HttpService, private router: Router) {
    this.equipaggiamento = this.router.getCurrentNavigation().extras.state.equipaggiamentoSelezionato;
    this.equipaggiamentoPos = this.router.getCurrentNavigation().extras.state.equipaggiamentoPos;
  }

  ngOnInit() {
  }

  TornaRiepilogoEquipaggiamenti(): void {
    this.router.navigate(['/RiepilogoEquipaggiamenti']);
  }

  Rimuovi(titanite: any): void {
    this.httpservice.Depotenzia(this.equipaggiamentoPos, titanite).subscribe(url => this.router.navigate([url]));
  }



}
