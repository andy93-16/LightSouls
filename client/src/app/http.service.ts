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
  public RiepilogoIncontro(): Observable<any>{
    return this.httpclient.get('http://localhost:8080/RiepilogoIncontro/');
  }
  public SetPersonaggio(): void  {
      this.httpclient.get('http://localhost:8080/SetPersonaggio').subscribe();
  }
  public RiepilogoPersonaggio(): Observable<any>{
    return this.httpclient.get<any>('http://localhost:8080/RiepilogoPersonaggio');
  }
  public Potenzia(equipaggiamentoPos: number, titanite: any): Observable<any> {
    return this.httpclient.post('http://localhost:8080/PotenziaEquipaggiamento/'
      + equipaggiamentoPos, titanite ,
      { responseType: 'text'});
  }
  public Depotenzia(id: number, titanite: any): Observable<any>{
    return this.httpclient.post('http://localhost:8080/DepotenziaEquipaggiamento/'
      + id, titanite ,
      { responseType: 'text'});
  }
  public Equipaggia(bodyParts: any[], equipaggiamentoPos: number): Observable<any> {
    return this.httpclient.post('http://localhost:8080/Equipaggia/' + equipaggiamentoPos , bodyParts ,
      {responseType: 'text'});
  }
  public Disequipaggia(equipaggiamentoPos: number): Observable<any> {
    return this.httpclient.get('http://localhost:8080/Disequipaggia/' + equipaggiamentoPos,
      {responseType: 'text'});
  }
  public ListaTurni(): Observable<any>{
    return this.httpclient.get('http://localhost:8080/ListaTurni');
  }
  public Attacca(attacco: any, posizioneNemico: number): Observable<any> {
    return this.httpclient.post('http://localhost:8080/Attacca/' + posizioneNemico,
       attacco, {responseType: 'text'});
  }
  public Difendi(): Observable<any> {
    return this.httpclient.get('http://localhost:8080/Difendi', {responseType: 'text'});
  }
  public Schiva(): Observable<any> {
    return this.httpclient.get('http://localhost:8080/Schiva', {responseType: 'text'});
  }
  public PassaTurno(): Observable<any> {
    return this.httpclient.get('http://localhost:8080/PassaTurno',{responseType: 'text'})
  }
  public GetLoot(): Observable<any> {
    return this.httpclient.get('http://localhost:8080/Loot')
  }
}
