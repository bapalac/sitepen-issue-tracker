import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandingComponent } from './landing';
import { RouterTestingModule } from '@angular/router/testing';

describe('Landing', () => {
  let component: LandingComponent;
  let fixture: ComponentFixture<LandingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LandingComponent, RouterTestingModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LandingComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
