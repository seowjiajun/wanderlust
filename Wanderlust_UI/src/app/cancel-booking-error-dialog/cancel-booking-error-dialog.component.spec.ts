import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelBookingErrorDialogComponent } from './cancel-booking-error-dialog.component';

describe('CancelBookingErrorDialogComponent', () => {
  let component: CancelBookingErrorDialogComponent;
  let fixture: ComponentFixture<CancelBookingErrorDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancelBookingErrorDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelBookingErrorDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
