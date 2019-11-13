import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RouterService} from "./router.service";
import {Incontro} from "./incontro";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpclient: HttpClient, private routerservice: RouterService) {
  }

  public IniziaNuovaPartita() {
      this.httpclient.get('http://localhost:8080/Modalita',
        {responseType: 'text'}).subscribe(url => this.routerservice.RouteTo(url)
      );
    }
  public ModalitaStoria() {
      this.httpclient.get('http://localhost:8080/ModalitaStoria',
        {responseType: 'text'}).subscribe(url => this.routerservice.RouteTo(url)
    );
    }
  public AvviaIncontro():Observable<Incontro> {
      return this.httpclient.get<Incontro>('http://localhost:8080/AvviaIncontro',
        {responseType: 'text'}).subscribe(incontro => {console.log(incontro);});
    }
}
