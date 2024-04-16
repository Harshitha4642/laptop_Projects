import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckItemsComponent } from './check-items.component';

describe('CheckItemsComponent', () => {
  let component: CheckItemsComponent;
  let fixture: ComponentFixture<CheckItemsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CheckItemsComponent]
    });
    fixture = TestBed.createComponent(CheckItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
