import { TestBed } from '@angular/core/testing';

import { RouterEvoService } from './router-evo.service';

describe('RouterEvoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RouterEvoService = TestBed.get(RouterEvoService);
    expect(service).toBeTruthy();
  });
});
