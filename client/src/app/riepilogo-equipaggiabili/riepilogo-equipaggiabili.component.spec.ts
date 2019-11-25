import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RiepilogoEquipaggiabiliComponent } from './riepilogo-equipaggiabili.component';

describe('RiepilogoEquipaggiabiliComponent', () => {
  let component: RiepilogoEquipaggiabiliComponent;
  let fixture: ComponentFixture<RiepilogoEquipaggiabiliComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RiepilogoEquipaggiabiliComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RiepilogoEquipaggiabiliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
