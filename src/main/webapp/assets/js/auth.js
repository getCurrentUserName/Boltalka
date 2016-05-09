var loginUsername = document.getElementById("loginUsername");
var loginPassword = document.getElementById("loginPassword");
var remember = document.getElementById("remember");

function login() {
    $.post(context + "/login", {
            username : loginUsername.value,
            password : loginPassword.value,
            'remember-me' : get_remember()
        })
        .done(function(data) {
            switch (data.result) {
                case "OK":
                    location=context + "/";
                    break;
                case "ANONYM":
                    show_message("Неправильный логин или пароль", 'danger');
                    break;
                default:
                    show_message("Произошла неизвестная ошибка", 'danger');
            }
        });
}

function loginRequest(username, password) {
    $.post(context + "/login", {
            username : username,
            password : password
        })
        .done(function(data) {
            switch (data.result) {
                case "OK":
                    location=context + "/";
                    break;
                default:
                    show_message("Произошла неизвестная ошибка при попытке авторизации", 'danger');
            }
        });
}

function show_message(text, priority) {
    $(document).trigger("add-alerts", [
        {
            'message': text,
            'priority': priority
        }
    ]);
}

function get_remember() {
    if (remember.checked) {
        return "On"
    } else {
        return "Off"
    }
}

$(function(){$('#register').attr({'action': context + '/register', 'method': 'post'});});