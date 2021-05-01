import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
  emailId: any;
  employee: any
  constructor(private route: ActivatedRoute, private employeService: EmployeeService) { }

  ngOnInit(): void {
    this.emailId = this.route.snapshot.params['emailId'];

  //  this.employee 
   // this.employeService.getEmployeeById(this.emailId).subscribe( data => {
    //  this.employee = data;
  //  });
  this.employee = new Employee();
    this.employeService.getEmployeeById(this.emailId).subscribe( data => {
      this.employee = data;
    });
  }

}
