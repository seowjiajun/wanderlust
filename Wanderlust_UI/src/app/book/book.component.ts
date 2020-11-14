import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { Booking } from '../models/Booking';
import { PackagesService } from '../service/packages.service';
import { BookingsService } from '../service/bookings.service';
import { ActivatedRoute } from '@angular/router';
import { Destination } from '../models/Destination';
import { LoginGuard } from '../service/login-guard.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  booking: Booking;
  destinationId: string;
  destination: Destination = null;
  packageInclusion: string[];
  totalCost: number;
  errorMessage: String = null;
  successMessage: String = null;

  constructor(private router: Router, private loginGuard: LoginGuard, private route: ActivatedRoute, 
    private packagesService: PackagesService, private bookingsService: BookingsService) { 
      if (!this.loginGuard.checkUser()) {
        this.router.navigate(['/login']);
      }
    }

  ngOnInit() {
    this.packagesService.getPackageById(this.route.snapshot.params.destinationId).subscribe(
      (response) => {
        this.destination = response;
        this.booking = new Booking();
        this.booking.noOfPeople = 1;
        this.booking.checkIn = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
        this.booking.checkOut = new Date(this.booking.checkIn.getTime() + (1000 * 60 * 60 * 24 * this.destination.noOfNights));
        this.packageInclusion = this.destination.details.packageInclusion.split(',');
        this.calculateCost(false);
    },
      (error) => {
        this.errorMessage = error.error.message;
        this.successMessage = null;
      }
    );
  }

  updateCheckOut(value) {
    this.booking.checkIn = new Date(value);
    this.booking.checkOut = new Date(new Date(value).getTime() + (1000 * 60 * 60 * 24 * this.destination.noOfNights));
  }

  calculateCost(includeFlight) {
    let pax: number = this.booking.noOfPeople;
    let chargePerPerson: number = this.destination.chargePerPerson;
    let flightCharge: number = this.destination.flightCharge;
    let discount: number = this.destination.discount / 100;
    this.totalCost = (chargePerPerson + (includeFlight ? flightCharge : 0)) * pax * (1 - discount);
    this.totalCost = Math.round(this.totalCost * 100) / 100;
    if (this.totalCost < 0) {
      this.totalCost = 0;
    }
  }

  onSubmit() {
    if (!this.loginGuard.checkUser()) {
      this.router.navigate(['/login']);
    }
    else if (this.booking.checkIn < new Date()) {
      this.errorMessage = 'The trip date must be after current date.';
      this.successMessage = null;
    }
    else {
      this.booking.checkOut = new Date(new Date(this.booking.checkIn).getTime() + (1000 * 60 * 60 * 24 * this.destination.noOfNights));
      this.booking.totalCost = this.totalCost;
      this.booking.destination = this.destination;
      this.booking.user = this.loginGuard.user;
      this.bookingsService.makeBooking(this.booking).subscribe(
        (response) => {
          this.successMessage = 'Booking ID ' + response.bookingId + ' has been made';
          this.errorMessage = null;
        },
        (error) => {
          this.errorMessage = error.error.message;
          this.successMessage = null;
        }
      );
    }
  }
}