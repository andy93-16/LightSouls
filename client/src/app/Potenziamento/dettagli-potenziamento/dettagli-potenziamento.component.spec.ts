import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DettagliPotenziamentoComponent } from './dettagli-potenziamento.component';

describe('DettagliPotenziamentoComponent', () => {
  let component: DettagliPotenziamentoComponent;
  let fixture: ComponentFixture<DettagliPotenziamentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DettagliPotenziamentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DettagliPotenziamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
