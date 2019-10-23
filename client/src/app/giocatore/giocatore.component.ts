import { Component, OnInit } from '@angular/core';
import {HttpService} from "../http.service";
import {RouterService} from "../router.service";


@Component({
  selector: 'app-giocatore',
  templateUrl: './giocatore.component.html',
  styleUrls: ['./giocatore.component.css']
})
export class GiocatoreComponent implements OnInit {

  constructor(private httpservice:HttpService) {
  }

  IniziaNuovaPartita():void {
    this.httpservice.IniziaNuovaPartita();
  }


  ngOnInit() {
  }

}
