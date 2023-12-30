import { Component, OnInit } from '@angular/core';
import { Reservation } from '../models/reservation.model';
import { ReservationService } from '../services/reservation.service';
import { Reservator } from '../models/reservator.model';
import { Resource } from '../models/resource.model';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit{

  reservations! : Reservation[]
  reservator! : Reservator
  resource! : Resource;
  public constructor(private reservationService: ReservationService){

  }

  public ngOnInit(){
    this.reservationService.getReservations().subscribe({
      next: data => {
        this.reservations = data 
      },
      error: err => {
        console.log(err)
      }
    })
  }

  showReservatorData(res: Reservator) {
    this.reservator = res
  }

  showResourceData(res: Resource) {
    this.resource = res
  }
  

}
