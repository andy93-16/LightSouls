import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DettagliEquipaggiamentoComponent } from './dettagli-equipaggiamento.component';

describe('DettagliEquipaggiamentoComponent', () => {
  let component: DettagliEquipaggiamentoComponent;
  let fixture: ComponentFixture<DettagliEquipaggiamentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DettagliEquipaggiamentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DettagliEquipaggiamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
