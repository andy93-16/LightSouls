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

  constructor(private httpservice: HttpService, private router: Router) {
    this.equipaggiamento = this.router.getCurrentNavigation().extras.state;
  }

  ngOnInit() {
  }

  TornaRiepilogoEquipaggiamenti(): void {
    this.router.navigate(['/RiepilogoEquipaggiamenti']);
  }

  Rimuovi(titanite: any): void {

    this.httpservice.Depotenzia(this.equipaggiamento.id, titanite).subscribe(url => this.router.navigate([url]));
  }



}
