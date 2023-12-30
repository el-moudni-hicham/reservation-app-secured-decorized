import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reservation } from '../models/reservation.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private baseURL = "http://localhost:8888/RESERVATION-SERVICE/reservation-api"

  constructor(private http: HttpClient) { }
  getReservations() : Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${this.baseURL}/reservations`);
  }
}
