import { Component, OnInit } from '@angular/core';
import {HttpService} from "../http.service";

@Component({
  selector: 'app-falo',
  templateUrl: './falo.component.html',
  styleUrls: ['./falo.component.css']
})
export class FaloComponent implements OnInit {

  constructor(private httpservice:HttpService) { }

  ngOnInit() {
  }

  AvviaIncontro():void{
    this.httpservice.AvviaIncontro();
  }

}
