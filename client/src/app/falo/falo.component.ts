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
    this.httpservice.ProcediAdIncontro().subscribe( incontro => {
      if (incontro === null) {
        this.router.navigate(['/RisultatoPartita']);
     }
     else {
       this.incontroCorrente = incontro;
      }
    });
  }

  ProcediAdIncontro(): void {
    this.router.navigate(['/Incontro'],{state:this.incontroCorrente});
  }

  Termina(): void {
    this.httpservice.Termina();
  }

  GestisciPersonaggio(): void {
    this.router.navigate(['/GestisciPersonaggio']);
  }

}
