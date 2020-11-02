import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'homepipe',
  pure:false
})
export class HomepipePipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    return value.join();
  }

}
