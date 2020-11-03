import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  /* template: `<h3 class="one">Hello World!</h3>`,
  styles: [`.one{color:red}`] */

  templateUrl:'./app.component.html',
  styleUrls:['./app.component.css']
})
export class AppComponent {
  title = 'firstAngularProject';
  pageHeader : string = "Employee Details";
  imagePath:string="flower.jpg";
  isDisabled : boolean = false;

  event = {id:10,name:"Ram",price:4000,location:"Chennai"};
  columnSpan : number =2;

classesToApply : string = "italicsClass boldClass";

isBold  :boolean =true;
fontsize: number = 30;
favoriteMovie :string =" Lord of the Rings";

add():void{
  console.log("Button Clicked");

}


}
