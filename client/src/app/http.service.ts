import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {RouterService} from './router.service';
import {Observable} from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpclient: HttpClient, private routerservice: RouterService) {
  }

  public IniziaNuovaPartita(): void {
      this.httpclient.get('http://localhost:8080/Modalita',
        {responseType: 'text'}).subscribe(url => this.routerservice.RouteTo([url])
      );
    }
  public ModalitaStoria(): void {
      this.httpclient.get('http://localhost:8080/ModalitaStoria',
        {responseType: 'text'}).subscribe(url => this.routerservice.RouteTo([url])
    );
    }
  public ProcediAdIncontro(): Observable<any> {
      return this.httpclient.get<any>('http://localhost:8080/ProcediAdIncontro') ;
    }
  public Termina(): void {
      this.httpclient.get('http://localhost:8080/Termina',
        {responseType: 'text'}).subscribe(url => this.routerservice.RouteTo([url]));
  }
  public AvviaIncontro(): void {
      this.httpclient.get('http://localhost:8080/AvviaIncontro',
        {responseType: 'text'}).subscribe(url => this.routerservice.RouteTo([url]));
  }
  public RiepilogoEquipaggiamenti(): Observable<any[]> {
      return this.httpclient.get<any[]>( 'http://localhost:8080/RiepilogoEquipaggiamenti');
  }
  public SetPersonaggio(): void  {
      this.httpclient.get('http://localhost:8080/SetPersonaggio').subscribe();
  }
  public DettagliEquipaggiamento(equipaggiamento:any): Observable<any[]> {
    return this.httpclient.get<any[]>('http://localhost:8080/DettagliEquipaggiamento/' + equipaggiamento.id,
      );
  }


}
