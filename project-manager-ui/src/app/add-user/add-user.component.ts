import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import { User} from '../model/User';
import {UserService} from '../services/user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  lastName: string;
  firstName: string;
  empId: string;
  user: User;
  users: User[];
  filteredUser: User[];
  btnTitle = 'Add';

  async getAllUsers()  {
    this.userService.get().subscribe( v => {
       this.users = v;
       this.filteredUser = this.users;
      this.ref.detectChanges();
      }
    );
  }

  constructor(private userService: UserService,private ref: ChangeDetectorRef) {
    this.empId = '';
    this.firstName = '';
    this.lastName = '';
    this.user = new User();
  }

  ngOnInit() {
     this.getAllUsers();
  }

  reset(): void {
    this.user = new User(' ', ' ', null);
    this.btnTitle = 'Add';
  }

  edit(usr: User): void {
    this.user = usr;
    this.btnTitle = 'Save';
  }

  onSubmit() {
   this.userService.add(new User(this.user.firstName, this.user.lastName, this.user.empId)).subscribe(
     v => {
       this.getAllUsers();
       this.btnTitle = 'Add';
       this.reset();
     }
   );
  }

  delete(usr: User) {
       this.userService.delete(usr).subscribe(
         v=> {
           this.getAllUsers();
           this.filteredUser = this.users;
      }
     );
  }

  async resetFilter() {
    await this.getAllUsers();
    this.filteredUser = this.users;
  }

  sortByFirstName() {
    this.filteredUser = this.users.sort ((a: any, b: any) =>
      b.firstName - a.firstName
    );
  }

  sortByLastName() {
    this.filteredUser = this.users.sort ((a: any, b: any) =>
      b.lastName - a.lastName
    );
  }

  sortById() {
    this.filteredUser = this.users.sort ((a: any, b: any) =>
      b.empId - a.empId
    );
  }
}
