import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TurnoNemicoComponent } from './turno-nemico.component';

describe('TurnoNemicoComponent', () => {
  let component: TurnoNemicoComponent;
  let fixture: ComponentFixture<TurnoNemicoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TurnoNemicoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TurnoNemicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
