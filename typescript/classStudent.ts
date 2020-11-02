class Student {

stuId: number; sname: string;
getAddress(): string {

return "Chennai";
}
 constructor(id:number,name:string){
	this.stuId=id;
	this.sname=name;

}

} let obj1=new Student(100,"Somu");

console.log(obj1.stuId);

console.log(obj1.sname); console.log(obj1.getAddress());

let obj2=new Student(200,"");