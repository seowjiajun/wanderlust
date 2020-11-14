import { Component, OnInit } from '@angular/core';
import { BookingsService } from '../service/bookings.service';
import { LoginGuard } from '../service/login-guard.service';
import { Router } from '@angular/router';
import { AuthService } from '../core/auth.service';
import { Booking } from '../models/Booking';
import { CancelBookingDialogService } from '../service/cancel-booking-dialog.service';
import { CancelBookingErrorDialogService } from '../service/cancel-booking-error-dialog.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css'],
  providers: [DatePipe]
})

export class BookingsComponent implements OnInit {

  private bookingList: Booking[] = [];
  private errorMessage: String = null;

  constructor(private loginGuard: LoginGuard, private router: Router, private auth: AuthService, 
    private bookingService: BookingsService, private cancelBookingDialogService: CancelBookingDialogService, 
    private datePipe: DatePipe, private cancelBookingErrorDialogService: CancelBookingErrorDialogService) {
    if (!this.loginGuard.checkUser()) {
      this.router.navigate(['/login']);
      return;
    }
  }

  ngOnInit() {
    this.getBookings();
  }

  getBookings() {
    this.bookingService.getBookings(this.auth.sessionUser.value.userId).subscribe(
      (response) => {
        this.bookingList = response;
        this.errorMessage = null;
      },
      (error) => {
        this.bookingList = [];
        this.errorMessage = null;
      }
     );
  }

  openCancelBookingDialog(bookingId: number) {
    let cancelBookingDialogMessage;
    for (let _i = 0; _i < this.bookingList.length; _i++) {
      if (this.bookingList[_i].bookingId == bookingId) {
        if (new Date(this.bookingList[_i].checkIn) < new Date()) {
          this.cancelBookingErrorDialogService.alert('Alert Cancellation', 'Unable to cancel booking after the check dates').then(
            (confirmed) => { }
          ).catch(
            (error) => { }
          );
          return;
        }
        cancelBookingDialogMessage = 'Trip start date: ' + this.datePipe.transform(this.bookingList[_i].checkIn, 'MMMM d, y') + '\nTrip end date: ' +
          this.datePipe.transform(this.bookingList[_i].checkOut, 'MMMM d, y') + '\nRefund amount: $' + this.bookingList[_i].totalCost;
        break;
      }
    }
    this.cancelBookingDialogService.confirm('Confirm Cancellation', cancelBookingDialogMessage).then(
      (confirmed) => {
        if (confirmed) {
          this.bookingService.cancelBooking(bookingId).subscribe(
            (response) => {
              this.getBookings();
              this.errorMessage = null;
              this.cancelBookingErrorDialogService.alert('Alert Cancellation', 'Booking successfully cancelled').then(
                (confirmed) => { }
              ).catch(
                (error) => { }
              );
            },
            (error) => {
              this.errorMessage = error.error.message;
            }
          );
        }
      }
    ).catch(
      (error) => { }
    );
  }
}