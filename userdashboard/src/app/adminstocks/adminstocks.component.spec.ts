import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminstocksComponent } from './adminstocks.component';

describe('AdminstocksComponent', () => {
  let component: AdminstocksComponent;
  let fixture: ComponentFixture<AdminstocksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminstocksComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminstocksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
