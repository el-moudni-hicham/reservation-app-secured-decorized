import { Component, OnInit } from '@angular/core';
import { ReservatorService } from '../services/reservator.service';

@Component({
  selector: 'app-reservator',
  templateUrl: './reservator.component.html',
  styleUrls: ['./reservator.component.css']
})
export class ReservatorComponent implements OnInit{
  reservators : any
  public constructor(private reservatorService: ReservatorService){

  }

  public ngOnInit(){
    this.reservatorService.getReservator().subscribe({
      next: data => {
        this.reservators = data
      },
      error: err => {
        console.log(err)
      }
    })
  }
}
