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
        document.getElementById("rollNo").value = student.rollNo;
        document.getElementById("program").value = student["domainDto"].program;
        document.getElementById("code").value = student["specialisationDto"].code;
        document.getElementById("cgpa").value = student.cgpa;
        if (student.imagePath !== undefined && student.imagePath !== 'null' && student.imagePath !== null) {
            let studentImage = document.getElementById("studentImage");
            studentImage.setAttribute('src', 'data:image/png;base64,' + student.imagePath);
            studentImage.setAttribute('width', '200em');
            studentImage.setAttribute('height', '200em');
        }
    }
};

handleUpdate = function (deleted) {
    let domainDto = {
        program: document.getElementById("program").value
    };
    let specialisationDto = {
        code: document.getElementById("code").value
    };
    let studentDto = {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        email: document.getElementById("email").value,
        totalCredits: document.getElementById("credit").value,
        graduationYear: document.getElementById("graduationYear").value,
        rollNo: document.getElementById("rollNo").value,
        domainDto: domainDto,
        specialisationDto: specialisationDto,
        cgpa: document.getElementById("cgpa").value,
        deleted: deleted
    };
    let formData = new FormData();
    formData.set("json", JSON.stringify(studentDto));
    let file = document.getElementById("uploadedImage").files[0];
    if (file !== undefined) {
        formData.append("file", file);
    }
    const http = new EasyHTTP();
    http.post("/student/details", formData)
        .then(data => {
            let serverMessage = document.getElementById("serverMessage");
            if (data.error === null || data.error === "null") {
                if (studentDto.deleted === true) {
                    handleDelete();
                } else {
                    document.getElementById("rollNo").value = data.rollNo;
                    if (data.imagePath !== undefined && data.imagePath !== 'null' && data.imagePath !== null) {
                        let studentImage = document.getElementById("studentImage");
                        studentImage.setAttribute('src', 'data:image/png;base64,' + data.imagePath);
                        studentImage.setAttribute('width', '200em');
                        studentImage.setAttribute('height', '200em');
                    }
                    serverMessage.style.color = 'green';
                    serverMessage.innerText = "Student record saved successfully";
                }
            } else {
                serverMessage.style.color = 'red';
                serverMessage.innerText = data.error;
            }
        })
        .catch(err => console.log(err));

    return false;
};

handleCancel = function () {
    sessionStorage.setItem("student", null);
    window.location.href = 'home.html';
    return false;
}

handleDelete = function () {
    handleCancel();
    return false;
};

displayImage = function () {
    let reader = new FileReader();
    reader.onload = function (e) {
        let studentImage = document.getElementById("studentImage");
        studentImage.setAttribute('src', e.target.result);
        studentImage.setAttribute('width', '200em');
        studentImage.setAttribute('height', '200em');
    };
    reader.readAsDataURL(document.getElementById("uploadedImage").files[0]);
    return false;
};

validateForUniqueEmail = function () {
    let request = {
        email: document.getElementById("email").value,
        rollNo: document.getElementById("rollNo").value
    };
    const http = new EasyHTTP();
    http.put("/student/validateUniqueEmail", request, "PUT", true)
        .then(data => {
            let email = document.getElementById('email');
            if (data.error !== null) {
                email.style.borderColor = 'red';
                email.setAttribute('title', data.error);
            } else {
                email.style.borderColor = '';
                email.removeAttribute('title');
            }
        })
        .catch(err => console.log(err));

    return false;
}