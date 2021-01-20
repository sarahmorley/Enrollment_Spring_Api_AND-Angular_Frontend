import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Course } from './course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }

  private coursesUrl = 'http://localhost:8002/courses';
  headers = {'content-type': 'application/json'};

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.coursesUrl)
  }
}
