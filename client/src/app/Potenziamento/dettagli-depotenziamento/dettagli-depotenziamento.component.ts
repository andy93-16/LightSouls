import { Component, OnInit } from '@angular/core';
import {HttpService} from "../../http.service";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-dettagli-depotenziamento',
  templateUrl: './dettagli-depotenziamento.component.html',
  styleUrls: ['./dettagli-depotenziamento.component.css']
})
export class DettagliDepotenziamentoComponent implements OnInit {
  equipaggiamento: any;
  pos: number;
  statoPersonaggio : any;

  constructor(private httpservice: HttpService, private route : ActivatedRoute, private router: Router) {
    this.route.params.subscribe(params => {
      this.pos = params['posizione']
    });
    this.httpservice.RiepilogoPersonaggio().subscribe(statoPersonaggio => {
      this.statoPersonaggio = statoPersonaggio;
      this.equipaggiamento = this.statoPersonaggio.personaggioBase.zainoEquip[this.pos];
    });
  }

  ngOnInit() {
  }

  TornaRiepilogoEquipaggiamenti(): void {
    this.router.navigate(['/RiepilogoEquipaggiamenti']);
  }

  Rimuovi(titanite: any): void {
    this.httpservice.Depotenzia(this.pos, titanite).subscribe(url => this.router.navigate([url]));
  }



}
