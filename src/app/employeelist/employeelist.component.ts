import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit {
  employees: Employee[]=[];

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees(){
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
      console.log(data);
    });
  }
  updateEmployee(emailId: string){
    this.router.navigate(['update-employee', emailId]);
  }
  employeeDetails(emailId: string){
    this.router.navigate(['employee-details', emailId]);
  }


  deleteEmployee(emailId: string){
    this.employeeService.deleteEmployee(emailId).subscribe( data => {
      console.log(data);
      this.getEmployees();
    })
  }
 
}


// function deleteEmployee(emailId: any, string: any) {
//   throw new Error('Function not implemented.');
// }

// function emailId(emailId: any, string: any) {
//   throw new Error('Function not implemented.');
// }

