import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'registerPipe'
})
export class RegisterPipe implements PipeTransform {

  transform(value: string): any {
      return 'Congratulations ' +value + '! You have successfully been registered to Wanderlust. Please log in to utilise most of our functionalities';
    
  }
}
