import { Component, OnInit } from '@angular/core';
import {HttpService} from '../http.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-falo',
  templateUrl: './falo.component.html',
  styleUrls: ['./falo.component.css']
})
export class FaloComponent implements OnInit {

  incontroCorrente: any;

  constructor(private httpservice: HttpService, private router: Router) {}

  ngOnInit() {
  }

  ProcediAdIncontro(): void {
    this.router.navigate(['/RiepilogoIncontro']);
  }

  Termina(): void {
    this.httpservice.Termina();
  }

  GestisciPersonaggio(): void {
    this.router.navigate(['/GestisciPersonaggio']);
  }

}
