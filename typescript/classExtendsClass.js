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
var Person = /** @class */ (function () {
    function Person(pname) {
        this.name = pname;
    }
    return Person;
}());
var Employee = /** @class */ (function (_super) {
    __extends(Employee, _super);
    function Employee(ecode, ename) {
        var _this = _super.call(this, ename) || this;
        _this.empCode = ecode;
        return _this;
    }
    Employee.prototype.display = function () {
        console.log("Name is " + this.name + "has code " + "" + this.empCode);
    };
    return Employee;
}(Person));
var emp = new Employee(100, "Ram");
console.log(emp.display());
console.log(emp.empCode);
