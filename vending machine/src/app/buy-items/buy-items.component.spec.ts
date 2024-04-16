import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuyItemsComponent } from './buy-items.component';

describe('BuyItemsComponent', () => {
  let component: BuyItemsComponent;
  let fixture: ComponentFixture<BuyItemsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BuyItemsComponent]
    });
    fixture = TestBed.createComponent(BuyItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
