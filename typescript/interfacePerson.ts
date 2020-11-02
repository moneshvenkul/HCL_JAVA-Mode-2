interface Person {

pid: number; pname: string; page?: number; }

let p: Person = { pid:10,pname:"Raj"}; //correct

console.log(p);

let p1: Person = { pid:11,pname:"Ram",page:23}; //correct

console.log(p1);

interface Employee{

readonly eno: number;

ename: string;

} let emp:Employee= {eno:12,ename:"Raj"};
 emp.ename="Ramu"; //correct 
//emp.eno=23; //wrong