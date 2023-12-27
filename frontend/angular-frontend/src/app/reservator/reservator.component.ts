import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reservator',
  templateUrl: './reservator.component.html',
  styleUrls: ['./reservator.component.css']
})
export class ReservatorComponent implements OnInit{
  reservators : any
  public constructor(private http: HttpClient){

  }

  public ngOnInit(){
    this.http.get("http://localhost:8888/RESERVATION-SERVICE/person-api/persons").subscribe({
      next : data => {
        this.reservators = data
      },
      error : err => {
        console.log(err)
      }
    })
  }
}
