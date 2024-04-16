import { TestBed } from '@angular/core/testing';

import { OdometerServiceService } from './odometer-service.service';

describe('OdometerServiceService', () => {
  let service: OdometerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OdometerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
