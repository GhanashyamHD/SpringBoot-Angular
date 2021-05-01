import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeelistComponent } from './employeelist/employeelist.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';

const routes: Routes = [
  {path: 'getAll', component: EmployeelistComponent},
  {path: 'create-employee', component: CreateEmployeeComponent},

  {path: 'update-employee/:emailId', component: UpdateEmployeeComponent},
  {path: 'employee-details/:emailId', component: EmployeeDetailsComponent},
  {path:'',redirectTo:'getAll',pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
