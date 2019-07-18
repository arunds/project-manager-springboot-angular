import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewTaskComponent } from './view-task/view-task.component';
import { AddTaskComponent } from './add-task/add-task.component';
import { UpdateTaskComponent } from './update-task/update-task.component';
import {AddProjectComponent} from './add-project/add-project.component';
import {AddUserComponent} from './add-user/add-user.component';

const routes: Routes = [
  { path: 'viewTask', component: ViewTaskComponent },
  { path: 'addTask', component:  AddTaskComponent },
  { path: 'updateTask', component: UpdateTaskComponent},
  { path: 'updateTask/:id', component: UpdateTaskComponent},
  { path: 'project', component: AddProjectComponent },
  { path: 'user', component: AddUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
