import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-risultato-partita',
  templateUrl: './risultato-partita.component.html',
  styleUrls: ['./risultato-partita.component.css']
})
export class RisultatoPartitaComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  TornaAlMenuPrincipale() : void {
    this.router.navigate(['/Giocatore']);

  }

}
