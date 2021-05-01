import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:8080/api";
  constructor(private httpClient: HttpClient) { }
  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}/getEmployee`);
    
  }
  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/postEmployee`, employee);
  }
  updateEmployee(emailId: string, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/updateEmployee/${emailId}`, employee);
  }
  getEmployeeById(emailId: string): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/getEmployeeId/${emailId}`);
  }
  deleteEmployee(emailId: string): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteEmployee/${emailId}`);
  }
}
