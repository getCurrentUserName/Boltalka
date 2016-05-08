<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">

    <form class="form-login">
        <h2 class="form-login-heading">Авторизация</h2>
        <label for="loginUsername" class="sr-only">Логин</label>
        <input type="text" id="loginUsername" class="form-control" placeholder="Логин" required autofocus>
        <label for="loginPassword" class="sr-only">Пароль</label>
        <input type="password" id="loginPassword" class="form-control" placeholder="Пароль" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Запомнить
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" onclick="login();" type="submit">Sign in</button>
    </form>

    <div class="toblur">
        <div class="fade in" data-alerts="alerts" data-fade="3000"></div>
    </div>

</div>

