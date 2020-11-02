var Student = /** @class */ (function () {
    function Student(id, name) {
        this.stuId = id;
        this.sname = name;
    }
    Student.prototype.getAddress = function () {
        return "Chennai";
    };
    return Student;
}());
var obj1 = new Student(100, "Somu");
console.log(obj1.stuId);
console.log(obj1.sname);
console.log(obj1.getAddress());
var obj2 = new Student(200, "");
