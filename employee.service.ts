import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8080/api/employee/';

  constructor(private http: HttpClient) { }

  getEmployee(id: number): Observable<any> {
    return this.http.get(this.baseUrl+id);
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(this.baseUrl, employee);
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.http.put(this.baseUrl, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+id, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    const employees = this.http.get(this.baseUrl);
    console.log(employees);
    return this.http.get(this.baseUrl);
  }
}
