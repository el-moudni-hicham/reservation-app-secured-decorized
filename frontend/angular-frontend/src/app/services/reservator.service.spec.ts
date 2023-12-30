import { TestBed } from '@angular/core/testing';

import { ReservatorService } from './reservator.service';

describe('ReservatorService', () => {
  let service: ReservatorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReservatorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
