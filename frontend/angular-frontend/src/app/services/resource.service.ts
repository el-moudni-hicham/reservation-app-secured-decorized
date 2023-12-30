import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Resource } from '../models/resource.model';

@Injectable({
  providedIn: 'root'
})
export class ResourceService {
  private BaseURL : string = "http://localhost:8888/RESOURCE-SERVICE/resource-api"
  constructor(private http: HttpClient) { }

  getResources() : Observable<Resource[]> {
      return this.http.get<Resource[]>(`${this.BaseURL}/resources`)
  }
}
