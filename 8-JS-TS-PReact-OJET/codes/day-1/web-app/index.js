function sayHello() {
    window.alert("welcome to web app");
    var header = document.getElementById("welcomeHeader");
    header.innerText = "welcome to js";

    var anilObject = {
        id: 1,
        name: 'anil',
        salary: 1000,
        print: function () {
            return `${this.id} ${this.name} ${this.salary}`;
        }
    };

    window.alert(anilObject.print());
}