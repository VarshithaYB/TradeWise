import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MystocksComponent } from './mystocks.component';

describe('MystocksComponent', () => {
  let component: MystocksComponent;
  let fixture: ComponentFixture<MystocksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MystocksComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MystocksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
