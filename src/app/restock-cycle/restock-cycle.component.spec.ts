import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestockCycleComponent } from './restock-cycle.component';

describe('RestockCycleComponent', () => {
  let component: RestockCycleComponent;
  let fixture: ComponentFixture<RestockCycleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RestockCycleComponent]
    });
    fixture = TestBed.createComponent(RestockCycleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
