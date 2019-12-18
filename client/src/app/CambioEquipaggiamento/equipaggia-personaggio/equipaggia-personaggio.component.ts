import {Component, OnDestroy, OnInit} from '@angular/core';
import {HttpService} from '../../http.service';
import {NavigationEnd, Router} from '@angular/router';

@Component({
  selector: 'app-equipaggia-personaggio',
  templateUrl: './equipaggia-personaggio.component.html',
  styleUrls: ['./equipaggia-personaggio.component.css']
})
export class EquipaggiaPersonaggioComponent implements OnInit{

  personaggio: any;
  equipaggiabili: any[] = [];
  nonEquipaggiabili: any[] = [];


  constructor(private httpservice: HttpService, private router: Router) {
  }

  ngOnInit() {
    this.httpservice.RiepilogoPersonaggio().subscribe(personaggio => {
      this.personaggio = personaggio;
      this.RiepilogoEquipaggiabili(); });
  }

  BodyPartsForEquipment(equipaggiamento: any): any[] {
    const bodyPartsFiltered: any[] = [];
    this.personaggio.bodyParts.forEach(bodyPart => {
      if (bodyPart.bodyPartType === equipaggiamento.bodyPartRequirement.bodyPartType) {
        bodyPartsFiltered.push(bodyPart); }
    }
    );
    return bodyPartsFiltered;
  }

  RiepilogoEquipaggiabili(): void {
    this.personaggio.zainoEquip.forEach ( equipaggiamento => {
      if (this.BodyPartsForEquipment(equipaggiamento).length >= equipaggiamento.bodyPartRequirement.numberbodyPart) {
        this.equipaggiabili.push(equipaggiamento); } else {
        this.nonEquipaggiabili.push(equipaggiamento);
      }});
  }

  ClearRiepilogoEquipaggiabili(): void {
    this.equipaggiabili = [];
    this.nonEquipaggiabili = [];
  }

  Equipaggia(equipaggiamento: any): void {
    this.router.navigate(['/ChooseBodyPart'],
      {state: { equipaggiamentoSelezionato: equipaggiamento, bodyPartsForEquipment: this.BodyPartsForEquipment(equipaggiamento)}});
  }

  Disequipaggia(equipaggiamentoId: number): void {
    this.httpservice.Disequipaggia(equipaggiamentoId).subscribe(
      url => {
        this.ClearRiepilogoEquipaggiabili();
        this.ngOnInit();
        }
    ); }
  TornaGestisciPersonaggio(): void {
    this.router.navigate([ '/GestisciPersonaggio']);
  }
}
