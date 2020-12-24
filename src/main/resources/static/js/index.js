function handleLogin() {
    let requestDto = {}
    requestDto.username = document.getElementById("login").value;
    requestDto.password = document.getElementById("pass").value;

    const http = new EasyHTTP();
    http.put("/admin/login", requestDto, "PUT", true)
        .then(data => {
            sessionStorage.setItem("isLoggedIn", data);
            if (data === true) {
                window.location.href = 'home.html';
            } else {
                document.getElementById("errorMessage").innerHTML = "Invalid credentials. Try again";
            }
        })
        .catch(err => console.log(err));

    return false;
}