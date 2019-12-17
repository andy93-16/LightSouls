import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RiepilogoEquipaggiamentiComponent } from './riepilogo-equipaggiamenti.component';

describe('RiepilogoEquipaggiabiliComponent', () => {
  let component: RiepilogoEquipaggiamentiComponent;
  let fixture: ComponentFixture<RiepilogoEquipaggiamentiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RiepilogoEquipaggiamentiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RiepilogoEquipaggiamentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
