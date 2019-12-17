import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-risultato-incontro',
  templateUrl: './risultato-incontro.component.html',
  styleUrls: ['./risultato-incontro.component.css']
})
export class RisultatoIncontroComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  TornaAlFalo(): void  {
    this.router.navigate(['/Falo']) ;
  }

}
