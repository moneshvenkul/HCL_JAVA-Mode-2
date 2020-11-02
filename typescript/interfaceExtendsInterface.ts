interface Person {

pid:number;

pname:string; page: number;
 }

interface Employee extends Person
 { empSal: number;

}

let emp: Employee={pid:10,pname:"Sam",page:24,empSal:20000}; console.log(emp);