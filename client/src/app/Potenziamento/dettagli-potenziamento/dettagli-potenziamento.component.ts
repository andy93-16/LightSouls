import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpService} from '../../http.service';
import {MatDialog} from '@angular/material';

@Component({
  selector: 'app-dettagli-equipaggiamento',
  templateUrl: './dettagli-potenziamento.component.html',
  styleUrls: ['./dettagli-potenziamento.component.css']
})
export class DettagliPotenziamentoComponent implements OnInit {

  pos : number;
  statoPersonaggio : any;
  equipaggiamento : any;
  titaniti: any[] = [];

  constructor(private httpservice: HttpService,private route : ActivatedRoute, private router: Router) {

    this.route.params.subscribe(params => {
      this.pos = params['posizione']
    });
    this.httpservice.RiepilogoPersonaggio().subscribe(statoPersonaggio => {
      this.statoPersonaggio = statoPersonaggio;
      this.equipaggiamento = this.statoPersonaggio.personaggioBase.zainoEquip[this.pos];
      this.TitanitiForEquipment(this.equipaggiamento);
    });
  }

  ngOnInit() {
  }

  TornaRiepilogoEquipaggiamenti(): void {
    this.router.navigate(['/RiepilogoEquipaggiamenti']);
  }

  Usa(titanite: any): void {
    this.httpservice.Potenzia(this.pos
      , titanite).subscribe(url => this.router.navigate([url]));
  }

  TitanitiForEquipment(equipaggiamento: any): void {
    this.statoPersonaggio.personaggioBase.titaniti.forEach( titanite => {
      if (titanite.equipmentType === equipaggiamento.type) {
        this.titaniti.push(titanite);
      }
    });

  }

}
