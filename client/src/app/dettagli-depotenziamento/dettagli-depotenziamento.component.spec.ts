import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DettagliDepotenziamentoComponent } from './dettagli-depotenziamento.component';

describe('DettagliDepotenziamentoComponent', () => {
  let component: DettagliDepotenziamentoComponent;
  let fixture: ComponentFixture<DettagliDepotenziamentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DettagliDepotenziamentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DettagliDepotenziamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
