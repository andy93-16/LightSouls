import { Component, OnInit } from '@angular/core';
import {HttpService} from '../http.service';


@Component({
  selector: 'app-giocatore',
  templateUrl: './giocatore.component.html',
  styleUrls: ['./giocatore.component.css']
})
export class GiocatoreComponent implements OnInit {

  constructor(private httpservice: HttpService) {
  }

  IniziaNuovaPartita(): void {
    this.httpservice.SetPersonaggio();
    this.httpservice.IniziaNuovaPartita();
  }


  ngOnInit() {
  }

}
