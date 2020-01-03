import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpService} from "../../http.service";

@Component({
  selector: 'app-risultato-incontro',
  templateUrl: './risultato-incontro.component.html',
  styleUrls: ['./risultato-incontro.component.css']
})
export class RisultatoIncontroComponent implements OnInit {

  loot : any;
  listaTurni : any[]=[];

  constructor(private router: Router,private httpservice: HttpService) {
    this.httpservice.ListaTurni().subscribe(listaTurni => {
      this.listaTurni = listaTurni;
    });
  }

  ngOnInit() {
  }

  TornaAlFalo(): void  {
    this.router.navigate(['/Falo']) ;
  }

}
