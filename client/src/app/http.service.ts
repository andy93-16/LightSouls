import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpclient: HttpClient, private router: Router) {
  }

  public IniziaNuovaPartita(): void {
      this.httpclient.get('http://localhost:8080/Modalita',
        {responseType: 'text'}).subscribe(url => this.router.navigate([url])
      );
    }
  public ModalitaStoria(): void {
      this.httpclient.get('http://localhost:8080/ModalitaStoria',
        {responseType: 'text'}).subscribe(url => this.router.navigate([url])
    );
    }
  public Termina(): void {
      this.httpclient.get('http://localhost:8080/Termina',
        {responseType: 'text'}).subscribe(url => this.router.navigate([url]));
  }
  public AvviaIncontro(): void {
      this.httpclient.get('http://localhost:8080/AvviaIncontro',
        {responseType: 'text'}).subscribe(url => this.router.navigate([url]));
  }
  public RiepilogoEquipaggiamenti(): Observable<any[]> {
      return this.httpclient.get<any[]>( 'http://localhost:8080/RiepilogoEquipaggiamenti');
  }
  public SetPersonaggio(): void  {
      this.httpclient.get('http://localhost:8080/SetPersonaggio').subscribe();
  }
  public TitanitiForEquipment(equipaggiamento: any): Observable<any[]> {
    return this.httpclient.get<any[]>('http://localhost:8080/TitanitiForEquipment/' +
      equipaggiamento.id);
  }
  public TitanitiOfEquipment(equipaggiamento: any): Observable<any[]> {
    return this.httpclient.get<any[]>('http://localhost:8080/TitanitiOfEquipment/' +
      equipaggiamento.id);
  }
  public Potenzia(id: number, titanite: any): Observable<any>{
    return this.httpclient.post('http://localhost:8080/PotenziaEquipaggiamento/'
      + id, titanite ,
      { responseType: 'text'});
  }
  public Depotenzia(id: number, titanite: any): Observable<any>{
    return this.httpclient.post('http://localhost:8080/DepotenziaEquipaggiamento/'
      + id, titanite ,
      { responseType: 'text'});
  }
  public RiepilogoEquipaggiati(): Observable<any[]> {
    return this.httpclient.get<any[]>('http://localhost:8080/RiepilogoEquipaggiati');
  }
  public RiepilogoNonEquipaggiabili(): Observable<any[]> {
    return this.httpclient.get<any[]>('http://localhost:8080/RiepilogoNonEquipaggiabili');
  }
  public RiepilogoEquipaggiabili(): Observable<any[]> {
    return this.httpclient.get<any[]>('http://localhost:8080/RiepilogoEquipaggiabili');
  }
  public BodyPartsForEquipment(equipaggiamento: any): Observable<any[]> {
    return this.httpclient.post<any[]>('http://localhost:8080/BodyPartsForEquipment', equipaggiamento);
  }
  public Equipaggia(bodyParts: any[], equipaggiamentoId: number): Observable<any> {
    return this.httpclient.post('http://localhost:8080/Equipaggia/' + equipaggiamentoId , bodyParts ,
      {responseType: 'text'});
  }
  public Disequipaggia(equipaggiamentoId: number): Observable<any> {
    return this.httpclient.get('http://localhost:8080/Disequipaggia/' + equipaggiamentoId,
      {responseType: 'text'});
  }
  public RiepilogoIncontro(): Observable<any>{
    return this.httpclient.get('http://localhost:8080/RiepilogoIncontro/');
  }



}
