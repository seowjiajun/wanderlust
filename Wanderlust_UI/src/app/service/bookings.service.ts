import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../models/Booking';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class BookingsService {

  constructor(private http: HttpClient) { }
  
  getBookings(userId: number): Observable<Booking[]> {
    return this.http.get<Booking[]>(environment.getBookings + userId);
  }

  cancelBooking(bookingId: number): Observable<Booking> {
    return this.http.get<Booking>(environment.cancelBooking + bookingId);
  }
  
  makeBooking(booking: Booking): Observable<Booking> {
    return this.http.post<Booking>(environment.makeBooking, booking);
  }
}
