var Employee = /** @class */ (function () {
    function Employee(id, name, salary, permanent) {
        this.empId = id;
        this.empName = name;
        this.empSalary = salary;
        this.empPermanent = permanent;
    }
    return Employee;
}());
var obj3 = { empId: "EM003", empName: "John", empSalary: 10000, empPermanent: true, departmentId: 1, departmentName: "Payroll", empSkills: [[1, "HTML"], [2, "CSS"], [3, "Javascript"]] };
console.log("id: " + obj3.empId);
console.log("name: " + obj3.empName);
console.log("salary: " + obj3.empSalary);
console.log("permanent: " + obj3.empPermanent);
console.log("department id: " + obj3.departmentId);
console.log("department name: " + obj3.departmentName);
var i;
for (i in obj3.empSkills)
    console.log("skill" + "[" + i + "]:" + obj3.empSkills[i]);
