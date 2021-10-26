import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientAppoitementComponent } from './patient-appoitement.component';

describe('PatientAppoitementComponent', () => {
  let component: PatientAppoitementComponent;
  let fixture: ComponentFixture<PatientAppoitementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientAppoitementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientAppoitementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
