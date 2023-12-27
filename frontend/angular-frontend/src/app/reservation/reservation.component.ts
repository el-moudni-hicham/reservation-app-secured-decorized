import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit{
  reservations : any
  public constructor(private http: HttpClient){

  }

  public ngOnInit(){
    this.http.get("http://localhost:8888/RESERVATION-SERVICE/reservation-api/reservations").subscribe({
      next: data => {
        this.reservations = data
      },
      error: err => {
        console.log(err)
      }
    })
  }

}
