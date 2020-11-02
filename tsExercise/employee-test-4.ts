class Employee {
	//id, name, salary, permanent

empId: string;
empName: string;
empSalary: number;
empPermanent: boolean;


constructor(id:string,name:string,salary:number,permanent:boolean){
	this.empId=id;
	this.empName=name;
	this.empSalary=salary;
	this.empPermanent=permanent;
}

}

/*interface Department extends Employee{
	departmentId : number;
	departmentName : string;
}

interface Skills extends Department{
	empSkills:[number,string][];
}


	let obj3:Skills={empId:"EM003", empName:"John", empSalary:10000, empPermanent:true,departmentId:1,departmentName:"Payroll",empSkills:[[1,"HTML"],[2,"CSS"],[3,"Javascript"]]};


console.log("id: "+obj3.empId);

console.log("name: "+obj3.empName);

console.log("salary: "+obj3.empSalary);

console.log("permanent: "+obj3.empPermanent);

console.log("department id: "+obj3.departmentId);

console.log("department name: "+obj3.departmentName);

let i;
for(i in obj3.empSkills)
	console.log("skill"+"["+i+"]:"+obj3.empSkills[i]);
*/
class EmployeeTest extends Employee{


	constructor(id:string,name:string,salary:number,permanent:boolean){
	super(id,name,salary,permanent);

}

	display():void{
		console.log("id: "+obj.empId);

console.log("name: "+obj.empName);

console.log("salary: "+obj.empSalary);

console.log("permanent: "+obj.empPermanent);
}

}

let obj=new EmployeeTest("EM003","John",10000,true);
obj.display()