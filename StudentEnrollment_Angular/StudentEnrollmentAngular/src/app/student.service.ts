import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule  } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { IStudent, Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  constructor(private http: HttpClient) { }

  private studentsUrl = 'http://localhost:8002/students';
  headers = {'content-type': 'application/json'};

  getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentsUrl)
  }

  getStudent(id: string): Observable<Student> {
    const url = `${this.studentsUrl}/${id}`;
    return this.http.get<Student>(url).pipe()
  }

  postStudent(student: Student): Observable<any> {
    const body = JSON.stringify(student);
    return this.http.post(this.studentsUrl, body, {'headers': this.headers});
  }

  patchStudent(student: Student): Observable<any> {
    const url = `${this.studentsUrl}/${student.id}`;   
    const body = JSON.stringify(student);
    return this.http.patch(url, body, {'headers': this.headers});
  } 


}
