import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  constructor(private CourseService: CourseService) { }

displayedColumns: string[] = ['id', 'name', 'description'];
dataSource = new MatTableDataSource<Course>();

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit() {
    this.getCoursesForTable(); 
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator
  }

  getCoursesForTable(): void {
    this.CourseService.getCourses()
    .subscribe(courses => this.dataSource.data = courses);
  }

}
