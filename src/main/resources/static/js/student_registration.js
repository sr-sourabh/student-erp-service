window.onload = () => {
    let isLoggedIn = sessionStorage.getItem("isLoggedIn");
    if (isLoggedIn !== "true") {
        window.location.href = 'index.html';
    }

    if (sessionStorage.getItem("student") !== "null") {
        let student = JSON.parse(sessionStorage.getItem("student"));
        console.log(student);
        document.getElementById("firstName").value = student.firstName;
        document.getElementById("lastName").value = student.lastName;
        document.getElementById("email").value = student.email;
        document.getElementById("credit").value = student.totalCredits;
        document.getElementById("graduationYear").value = student.graduationYear;

    }
};

handleUpdate = function () {
    let studentDto = {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        email: document.getElementById("email").value,
        totalCredits: document.getElementById("credit").value,
        graduationYear: document.getElementById("graduationYear").value
    };
    let formData = new FormData();
    formData.set("json", JSON.stringify(studentDto));
    const http = new EasyHTTP();
    http.post("/student/details", formData)
        .then(data => {
            console.log(data);
        })
        .catch(err => console.log(err));

    return false;
};