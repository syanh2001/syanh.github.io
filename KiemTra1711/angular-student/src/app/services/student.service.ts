import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from '../models/student.model';

const baseUrl = 'http://localhost:8080/api/hocsinhs';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  constructor(private http: HttpClient) {}
  getAll(): Observable<Student[]> {
    return this.http.get<Student[]>(baseUrl);
  }
  get(mahs_syanh: any): Observable<Student> {
    return this.http.get(`${baseUrl}/${mahs_syanh}`);
  }
  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }
  update(mahs_syanh: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${mahs_syanh}`, data);
  }
  delete(mahs_syanh: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${mahs_syanh}`);
    
  }
  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }
  findByName(lophoc: any): Observable<Student[]> {
    return this.http.get<Student[]>(`${baseUrl}?lophoc=${lophoc}`);
  }
}
