import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Student } from '../student';
import { StudentService} from '../student.service';
import { MatPaginator } from '@angular/material/paginator';
import { FormBuilder } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  constructor(private StudentService: StudentService,
              private formBuilder: FormBuilder
              ) { }

  studentForm = this.formBuilder.group({
    name: '', address: ''
  });

  displayedColumns: string[] = ['id', 'name', 'address'];
  dataSource = new MatTableDataSource<Student>();
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit() {
    this.getStudentsForTable(); 
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator
}
  
   getStudentsForTable(): void {
    this.StudentService.getStudents()
    .subscribe(students => this.dataSource.data = students);
  }

  postStudent( name: string, address: string) {
    let student = new Student();
    student.name = name;
    student.address = address;
    this.StudentService.postStudent(student)
    .subscribe(students => this.getStudentsForTable());
  }

  createStudent(): void {
    this.postStudent(this.studentForm.get('name').value, this.studentForm.get('address').value)
  }

}
