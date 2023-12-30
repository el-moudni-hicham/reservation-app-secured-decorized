import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservator } from '../models/reservator.model';

@Injectable({
  providedIn: 'root'
})
export class ReservatorService {
  private baseUrl = "http://localhost:8888/RESERVATION-SERVICE/person-api/"
  constructor(private http: HttpClient) { }

  getReservator() : Observable<Reservator[]>{
    return this.http.get<Reservator[]>(`${this.baseUrl}/persons`)
  }
}
