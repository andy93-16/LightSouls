import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {RouterEvoService} from "../router-evo.service";

@Component({
  selector: 'app-cambia-equipaggiamento',
  templateUrl: './cambia-equipaggiamento.component.html',
  styleUrls: ['./cambia-equipaggiamento.component.css']
})
export class CambiaEquipaggiamentoComponent implements OnInit {

  constructor(private routerEvo: RouterEvoService) { }

  ngOnInit() {
  }
  TornaIndietro(): void {
    this.routerEvo.navigate([this.routerEvo.previousUrl]);
  }

  GetRouterEvo(): RouterEvoService {
    return this.routerEvo;
  }

}
