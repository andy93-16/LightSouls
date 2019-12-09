import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CambiaEquipaggiamentoComponent } from './cambia-equipaggiamento.component';

describe('CambiaEquipaggiamentoComponent', () => {
  let component: CambiaEquipaggiamentoComponent;
  let fixture: ComponentFixture<CambiaEquipaggiamentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CambiaEquipaggiamentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CambiaEquipaggiamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
