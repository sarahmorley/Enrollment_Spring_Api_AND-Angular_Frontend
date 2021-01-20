import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Enrollment } from './enrollment';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {
  constructor(private http: HttpClient) { }

  private enrollmentUrl = 'http://localhost:8002/enrollments';
  headers = {'content-type': 'application/json'};

  getStudentsInCourse(id: string): Observable<Enrollment[]> {
    const url = `${this.enrollmentUrl}/${id}`;
    return this.http.get<Enrollment[]>(url).pipe()
  }
}
