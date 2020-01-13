import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpService} from "../../http.service";

@Component({
  selector: 'app-choose-body-part',
  templateUrl: './choose-body-part.component.html',
  styleUrls: ['./choose-body-part.component.css']
})


export class ChooseBodyPartComponent implements OnInit {

  equipaggiamentoPos: any;
  equipaggiamento: any;
  bodyParts: any[];
  bodyPartsSelected: any[] = [];
  prevUrl: any;

  constructor(private router: Router, private httpservice: HttpService) {
    this.equipaggiamento = this.router.getCurrentNavigation().extras.state.equipaggiamentoSelezionato;
    this.equipaggiamentoPos = this.router.getCurrentNavigation().extras.state.equipaggiamentoPos;
    this.bodyParts = this.router.getCurrentNavigation().extras.state.bodyPartsForEquipment;
    this.prevUrl=this.router.getCurrentNavigation().extras.state.prevUrl;
  }
  ngOnInit() {
  }

  Select(bodypart: any): void {
    this.bodyPartsSelected.push(bodypart);
    this.bodyParts.splice( this.bodyParts.indexOf(bodypart),1);
  }
  Deselect(bodypart: any): void {
    this.bodyPartsSelected.splice(this.bodyPartsSelected.indexOf(bodypart),1)
    this.bodyParts.push(bodypart);
  }
  Conferma(): void {
    this.httpservice.Equipaggia(this.bodyPartsSelected,this.equipaggiamentoPos).subscribe(
      url => this.router.navigate(['/EquipaggiaPersonaggio'], { state :
          { prevUrl : this.prevUrl } }));
  }
  TornaAEquipaggiaPersonaggio(): void {
    this.router.navigate(['/EquipaggiaPersonaggio'], { state :
        { prevUrl : this.prevUrl } });
  }



}
