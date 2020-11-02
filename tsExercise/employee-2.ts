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

interface Department extends Employee{
	departmentId : number;
	departmentName : string;
}


	let obj2:Department={empId:"EM003", empName:"John", empSalary:10000, empPermanent:true,departmentId:1,departmentName:"Payroll"};


console.log("id: "+obj2.empId);

console.log("name: "+obj2.empName);

console.log("salary: "+obj2.empSalary);

console.log("permanent: "+obj2.empPermanent);

console.log("department id: "+obj2.departmentId);

console.log("department name: "+obj2.departmentName);


