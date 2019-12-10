import { Component, OnInit } from '@angular/core';
import {HttpService} from '../http.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-cambia-equipaggiamento',
  templateUrl: './cambia-equipaggiamento.component.html',
  styleUrls: ['./cambia-equipaggiamento.component.css']
})
export class CambiaEquipaggiamentoComponent implements OnInit {

  currentEquipped: any[];

  constructor(private router: Router, private httpservice: HttpService) {
    this.httpservice.RiepilogoEquipaggiati().subscribe(equipaggiati => this.currentEquipped = equipaggiati);
  }

  ngOnInit() {
  }

  Cambia(equipaggiamentoDaCambiare: any): void {
    this.router.navigate(['/RiepilogoEquipaggiabili'],{state : equipaggiamentoDaCambiare});
  }

/*  TornaIndietro(): void {
    this.routerEvo.navigate([this.routerpreviousUrl]);
  }*/

}
