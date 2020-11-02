var Employee = /** @class */ (function () {
    function Employee(id, name, salary, permanent) {
        this.empId = id;
        this.empName = name;
        this.empSalary = salary;
        this.empPermanent = permanent;
    }
    return Employee;
}());
var obj2 = { empId: "EM003", empName: "John", empSalary: 10000, empPermanent: true, departmentId: 1, departmentName: "Payroll" };
console.log("id: " + obj2.empId);
console.log("name: " + obj2.empName);
console.log("salary: " + obj2.empSalary);
console.log("permanent: " + obj2.empPermanent);
console.log("department id: " + obj2.departmentId);
console.log("department name: " + obj2.departmentName);
