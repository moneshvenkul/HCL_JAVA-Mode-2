class Person { 
	name:string;
}

interface Emp extends Person {

	code:number;
}

let emp1:Emp={code:1,name:"Ram"};
console.log(emp1);