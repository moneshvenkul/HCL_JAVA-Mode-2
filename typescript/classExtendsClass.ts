class Person {

name: string;

constructor(pname:string){ this.name=pname;

}

} 

class Employee extends Person {

empCode:number;
constructor(ecode:number,ename:string){
super(ename);

this.empCode=ecode;
} display():void{
console.log("Name is "+this.name+"has code "+ ""+this.empCode);
}
} 
let emp = new Employee(100,"Ram");
console.log(emp.display());
console.log(emp.empCode);
