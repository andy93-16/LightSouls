import { Component, OnInit } from '@angular/core';
import {RouterService} from "../router.service";

@Component({
  selector: 'app-risultato-partita',
  templateUrl: './risultato-partita.component.html',
  styleUrls: ['./risultato-partita.component.css']
})
export class RisultatoPartitaComponent implements OnInit {

  constructor(private routerService: RouterService) { }

  ngOnInit() {
  }

  TornaAlMenuPrincipale() : void {
    this.routerService.RouteTo('/Giocatore');

  }

}
