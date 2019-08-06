import { TestBed } from '@angular/core/testing';

import { ContactReasonService } from './contact-reason.service';

describe('ContactServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ContactReasonService = TestBed.get(ContactReasonService);
    expect(service).toBeTruthy();
  });
});
