var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Employee = /** @class */ (function () {
    function Employee(id, name, salary, permanent) {
        this.empId = id;
        this.empName = name;
        this.empSalary = salary;
        this.empPermanent = permanent;
    }
    return Employee;
}());
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
var EmployeeTest = /** @class */ (function (_super) {
    __extends(EmployeeTest, _super);
    function EmployeeTest(id, name, salary, permanent) {
        return _super.call(this, id, name, salary, permanent) || this;
    }
    EmployeeTest.prototype.display = function () {
        console.log("id: " + obj.empId);
        console.log("name: " + obj.empName);
        console.log("salary: " + obj.empSalary);
        console.log("permanent: " + obj.empPermanent);
    };
    return EmployeeTest;
}(Employee));
var obj = new EmployeeTest("EM003", "John", 10000, true);
obj.display();
