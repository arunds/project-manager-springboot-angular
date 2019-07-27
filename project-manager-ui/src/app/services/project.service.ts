import { Injectable } from '@angular/core';
import {Project} from '../model/Project';
import {User} from '../model/User';
import {promise} from 'selenium-webdriver';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  http: HttpClient;
  endpoint = 'http://localhost:8080/project/projects';

  constructor(http: HttpClient ) {
    this.http = http;
  }

  get(): Observable<Project[]> {
    return this.http.get<Project[]>(this.endpoint);
  }

  update(proj: Project): Observable<Project> {
    console.log(proj);
    return this.http.post<Project>(this.endpoint,proj);
  }

  add( proj: Project): Observable<Project> {
    console.log(proj);
    return this.http.post<Project>('http://localhost:8080/project/',proj);
  }
}
