import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChooseBodyPartComponent } from './choose-body-part.component';

describe('ChooseBodyPartComponent', () => {
  let component: ChooseBodyPartComponent;
  let fixture: ComponentFixture<ChooseBodyPartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChooseBodyPartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChooseBodyPartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
