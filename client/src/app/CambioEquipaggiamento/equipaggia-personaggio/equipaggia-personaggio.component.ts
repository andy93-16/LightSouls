import {Component, OnDestroy, OnInit} from '@angular/core';
import {HttpService} from '../../http.service';
import {NavigationEnd, Router} from '@angular/router';

@Component({
  selector: 'app-equipaggia-personaggio',
  templateUrl: './equipaggia-personaggio.component.html',
  styleUrls: ['./equipaggia-personaggio.component.css']
})
export class EquipaggiaPersonaggioComponent implements OnInit{

  statoPersonaggio: any;
  equipaggiabili: any[] = [];
  nonEquipaggiabili: any[] = [];
  prevUrl: any;


  constructor(private httpservice: HttpService, private router: Router) {
    this.prevUrl=this.router.getCurrentNavigation().extras.state.prevUrl;
  }

  ngOnInit() {
    this.httpservice.RiepilogoPersonaggio().subscribe(statoPersonaggio => {
      this.statoPersonaggio = statoPersonaggio;
      this.RiepilogoEquipaggiabili(); });
  }

  BodyPartsForEquipment(equipaggiamento: any): any[] {
    const bodyPartsFiltered: any[] = [];
    this.statoPersonaggio.personaggioBase.bodyParts.forEach(bodyPart => {
      if (bodyPart.bodyPartType === equipaggiamento.bodyPartRequirement.bodyPartType) {
        bodyPartsFiltered.push(bodyPart); }
    }
    );
    return bodyPartsFiltered;
  }

  RiepilogoEquipaggiabili(): void {
    this.statoPersonaggio.personaggioBase.zainoEquip.forEach ( equipaggiamento => {
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
      {skipLocationChange: true, state: { equipaggiamentoPos: this.statoPersonaggio.personaggioBase.zainoEquip.indexOf(equipaggiamento),
          equipaggiamentoSelezionato: equipaggiamento,
          bodyPartsForEquipment: this.BodyPartsForEquipment(equipaggiamento),
          prevUrl:this.prevUrl
          }});
  }

  Disequipaggia(equipaggiamento: any): void {
    this.httpservice.Disequipaggia(this.statoPersonaggio.equipaggiati.indexOf(equipaggiamento)).subscribe(
      url => {
        this.ClearRiepilogoEquipaggiabili();
        this.ngOnInit();
        }
    ); }

  TornaIndietro(): void {
    this.router.navigate([this.prevUrl]);
  }
}
