import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservatorComponent } from './reservator.component';

describe('ReservatorComponent', () => {
  let component: ReservatorComponent;
  let fixture: ComponentFixture<ReservatorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReservatorComponent]
    });
    fixture = TestBed.createComponent(ReservatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
