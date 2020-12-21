function handleLogin() {
    let requestDto = {}
    requestDto.username = $("#login").val();
    requestDto.password = $("#pass").val();

    const http = new EasyHTTP();
    http.update("/admin/login", requestDto, "PUT")
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