interface Employee { empNo: number; empName: string; }

let emp:Employee = {empNo:1,empName:"Ram"};
 console.log(emp);
  console.log(emp.empNo);
   console.log(emp.empName);

  interface MyInterface {

a: number; hello(): void;

}
let ex: MyInterface ={a:10,hello(){

console.log("Hello");

}}; console.log(ex.a); console.log(ex.hello());