import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../http.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-incontro',
  templateUrl: './riepilogo-incontro.component.html',
  styleUrls: ['./riepilogo-incontro.css']
})
export class RiepilogoIncontroComponent implements OnInit {

  descrittoreIncontro: any = [];

  constructor(private httpservice: HttpService, private router: Router) {
    this.httpservice.RiepilogoIncontro().subscribe(
      descrittoreIncontro => { this.descrittoreIncontro = descrittoreIncontro;}
    );
  }

  ngOnInit() {
  }

  public AvviaIncontro(): void {
    this.httpservice.AvviaIncontro();
    }

  TornaAlFalo(): void  {
    this.router.navigate(['/Falo']) ;
  }

}
