import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { EnrollmentService } from '../enrollment.service';
import { Enrollment } from '../enrollment';

@Component({
  selector: 'app-course-detail',
  templateUrl: './course-detail.component.html',
  styleUrls: ['./course-detail.component.css']
})
export class CourseDetailComponent implements OnInit {
 
  constructor(private route: ActivatedRoute,
    private enrollmentServie: EnrollmentService) { }

  displayedColumns: string[] = ['id'];
  dataSource = new MatTableDataSource<Enrollment>();

  ngOnInit(): void {
    this.getStudents();
  }

  getStudents(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.enrollmentServie.getStudentsInCourse(id!)
    .subscribe(students => this.dataSource.data = students);
  }

}
