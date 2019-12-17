import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpService} from "../http.service";

@Component({
  selector: 'app-choose-body-part',
  templateUrl: './choose-body-part.component.html',
  styleUrls: ['./choose-body-part.component.css']
})
export class ChooseBodyPartComponent implements OnInit {

  equipaggiamento: any;
  bodyParts: any[];
  bodyPartsSelected: any[] = [];

  constructor(private router: Router, private httpservice: HttpService) {
    this.equipaggiamento = this.router.getCurrentNavigation().extras.state.equipaggiamentoSelezionato;
    this.httpservice.BodyPartsForEquipment(this.equipaggiamento).subscribe(
      bodyParts => this.bodyParts = bodyParts );
  }

  ngOnInit() {
  }

  Select(bodypart: any): void{
    this.bodyPartsSelected.push(bodypart);
  }
  Deselect(bodypart: any): void {
    this.bodyPartsSelected.splice(bodypart);
  }

  Conferma(): void {
    this.httpservice.Equipaggia(this.bodyPartsSelected, this.equipaggiamento.id).subscribe(
      url => this.router.navigate([url]));
  }

  TornaAEquipaggiaPersonaggio(): void {
    this.router.navigate(['/EquipaggiaPersonaggio']);
  }

}
