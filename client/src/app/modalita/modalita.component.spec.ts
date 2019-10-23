import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalitaComponent } from './modalita.component';

describe('ModalitaComponent', () => {
  let component: ModalitaComponent;
  let fixture: ComponentFixture<ModalitaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalitaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
