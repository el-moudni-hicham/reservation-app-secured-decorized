import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'


@Component({
  selector: 'app-resource',
  templateUrl: './resource.component.html',
  styleUrls: ['./resource.component.css']
})
export class ResourceComponent implements OnInit{
  resources : any
  constructor(private http: HttpClient) {

  }
  ngOnInit() {
    this.http.get('http://localhost:8888/RESOURCE-SERVICE/resource-api/resources').subscribe({
      next : data => {
        this.resources = data
      },
      error : err => {
        console.log(err)
      }
    })
  }

}
