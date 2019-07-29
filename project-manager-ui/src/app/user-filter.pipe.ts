import { Pipe, PipeTransform } from '@angular/core';
import { User } from './model/User';

@Pipe({
  name: 'userFilter'
})
export class UserFilterPipe implements PipeTransform {

  transform(users: Array<User>, filterByUser?: string) {
    if (filterByUser) {
      users = users.filter(project =>
        project.firstName.toLowerCase().startsWith(filterByUser.toLowerCase()));
    }
    return users;
  }

}
