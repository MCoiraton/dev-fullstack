import { TestBed } from '@angular/core/testing';

import { CenterManagementService } from './center-management.service';

describe('CenterManagementService', () => {
  let service: CenterManagementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CenterManagementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
