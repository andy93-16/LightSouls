import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../http.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-riepilogo-equipaggiamenti',
  templateUrl: './riepilogo-equipaggiamenti.component.html',
  styleUrls: ['./riepilogo-equipaggiamenti.component.css']
})
export class RiepilogoEquipaggiamentiComponent implements OnInit {

  personaggio: any;
  equipaggiamenti: any[] = [];

  constructor(private httpservice: HttpService, private router: Router) {
    this.httpservice.RiepilogoPersonaggio().subscribe(personaggio => {
      this.personaggio = personaggio;
      this.equipaggiamenti = this.equipaggiamenti.concat(this.personaggio.zainoEquip)
        .concat(this.personaggio.equipaggiati);
      });
  }

  ngOnInit() {
  }

  DettagliPotenziamento(equipaggiamento: any): void {
    this.router.navigate(['/DettagliPotenziamento'], { state: equipaggiamento});
  }

  DettagliDepotenziamento(equipaggiamento: any): void {
    this.router.navigate(['/DettagliDepotenziamento'], { state: equipaggiamento});
  }

  TornaGestisciPersonaggio(): void {
    this.router.navigate(['/GestisciPersonaggio']);
  }
}
