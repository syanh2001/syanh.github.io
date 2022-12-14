import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/models/student.model';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css'],
})
export class AddStudentComponent implements OnInit {
  student: Student = {
    lophoc: '',
    diemtoan: '',
    diemvan: '',
    quequan: '',
    ngayvaotruong: 'M/d/yy' ,
  };
  submitted = false;
  constructor(private studentService: StudentService) {}
  ngOnInit(): void {}
  saveStudent(): void {
    console.log(this.student.diemtoan);
    const data = {
      lophoc: this.student.lophoc,
      diemtoan: this.student.diemtoan,
      diemvan: this.student.diemvan,
      quequan: this.student.quequan,
      ngayvaotruong: this.student.ngayvaotruong,
    };
    this.studentService.create(data).subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e),
    });
  }
  newStudent(): void {
    this.submitted = false;
    this.student = {
      lophoc: '',
      diemtoan: '',
      diemvan: '',
      quequan: '',
      ngayvaotruong: '',
    };
  }
}
