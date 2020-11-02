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

} let obj1=new Employee("EM003","John",10000,true);

console.log("id: "+obj1.empId);

console.log("name: "+obj1.empName);

console.log("salary: "+obj1.empSalary);

console.log("permanent: "+obj1.empPermanent);
