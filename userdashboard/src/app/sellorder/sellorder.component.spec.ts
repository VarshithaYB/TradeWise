import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellorderComponent } from './sellorder.component';

describe('SellorderComponent', () => {
  let component: SellorderComponent;
  let fixture: ComponentFixture<SellorderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SellorderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SellorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
