let a:number=12;
console.log(a);
let b: string = "";
console.log(b); //empty
let empName: string ="Sam";
let empDept: string="HR";
let output: string = empName+" works in "+empDept;
console.log(output);
let output1: string = `${empName} works is ${empDept}`; 
console.log(output1); let isDone: boolean = false;
console.log(isDone);
function hello():void{
	console.log("welcome");
}
console.log(hello());
let t:void = undefined; //uninitialized variable
console.log(t);
t=null; //value is null
console.log(t);
function hello1(x:any,y:any){

return x+y;

}

let s=hello1(2, 'hello');

console.log(s);

s=hello1(4,6); console.log(s);

