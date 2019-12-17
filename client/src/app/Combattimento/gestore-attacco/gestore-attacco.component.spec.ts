import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestoreAttaccoComponent } from './gestore-attacco.component';

describe('GestoreAttaccoComponent', () => {
  let component: GestoreAttaccoComponent;
  let fixture: ComponentFixture<GestoreAttaccoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestoreAttaccoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestoreAttaccoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
