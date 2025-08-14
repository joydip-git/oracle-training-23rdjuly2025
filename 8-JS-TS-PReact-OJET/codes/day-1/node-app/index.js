// function person(id, name, salary) {
//     this.id = id;
//     this.name = name;
//     this.salary = salary;
// }
// person.prototype.print = function () {
//     return `ID: ${this.id}, Name: ${this.name}, Salary: ${this.salary}`;
// };

class Person {
    id;
    name;
    salary;
    constructor(id, name, salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    print() {
        return `ID: ${this.id}, Name: ${this.name}, Salary: ${this.salary}`;
    }
}
const anilperson = new Person(1, "John Doe", 50000);

function add(x, y) {
    return x + y;
}
