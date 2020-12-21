window.onload = () => {
    let isLoggedIn = sessionStorage.getItem("isLoggedIn");
    if (isLoggedIn !== "true") {
        window.location.href = 'index.html';
    }

    const http = new EasyHTTP();
    http.get("/student/details")
        .then(data => {
            studentMap = {};
            let innerHtml = "";
            for (i = 0; i < data.length; i++) {
                studentMap[data[i].rollNo] = data[i];
                innerHtml += " <tr> ";
                innerHtml += " <td> " + data[i].rollNo + " </td> ";
                innerHtml += " <td> " + data[i].firstName + " " + data[i].lastName + " </td> ";
                let viewButton = " <button id= " + data[i].rollNo + " onclick = 'return handleView(studentMap[this.id])' title=\"view this user\" class=\"btn btn-default btn-sm \"> <i class=\"glyphicon glyphicon-eye-open text-primary\"></i> </button> ";
                innerHtml += " <td> " + viewButton + " </td> " + " </tr> ";
            }
            document.getElementById("form-list-client-body").innerHTML = innerHtml;
        })
        .catch(err => console.log(err));
};

handleView = function (student) {
    //populate student details and give option for edit and delete
    if (student !== null) {
        sessionStorage.setItem("student", JSON.stringify(student));
        window.location.href = 'student_registration.html';
    }
    return false;
}

addNewStudent = function () {
    sessionStorage.setItem("student", null);
    window.location.href = 'student_registration.html';
    return false;
}

