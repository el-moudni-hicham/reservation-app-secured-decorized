import { ResourceService } from './../services/resource.service';
import { Component, OnInit } from '@angular/core';
import { Resource } from '../models/resource.model';


@Component({
  selector: 'app-resource',
  templateUrl: './resource.component.html',
  styleUrls: ['./resource.component.css']
})
export class ResourceComponent implements OnInit{
  resources! : Resource[]
  constructor(private resourceService: ResourceService) {

  }
  ngOnInit() {
    this.resourceService.getResources().subscribe({
      next : data => {
        this.resources = data
      },
      error : err => {
        console.log(err)
      }
    })
  }

}
