<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ru" xmlns:sitemesh="sitemesh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="UTF-8">
    <title>Boltalka</title>
    <link rel="stylesheet" href="/assets/bootstrap/fonts/glyphicons-halflings-regular.ttf">
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/assets/style/auth.css">
</head>
<body>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Boltalka</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">Новости</a></li>
                <li><a href="#">О нас</a></li>
                <li><a href="#">Контакты</a></li>
                <li><a href="/room">Комнаты</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="${menuLogin}"><a href="#" data-toggle="modal" data-target="#loginModal">Вход</a></li>
                <li class="${menuRegister}"><a href="/register">Регистрация</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="container-fluid">
        <sitemesh:write property='body'/>
    </div>
</div>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="form-login">
                <h2 class="form-login-heading">Авторизация</h2>
                <label for="loginUsername" class="sr-only">Логин</label>
                <input type="text" id="loginUsername" class="form-control" placeholder="Логин" required autofocus>

                <label for="loginPassword" class="sr-only">Пароль</label>
                <input type="password" id="loginPassword" class="form-control" placeholder="Пароль" required>

                <div class="checkbox">
                    <label>
                        <input type="checkbox" id="remember" value="remember-me"> Запомнить
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" onclick="login();" type="submit">Войти</button>
            </div>

            <div class="toblur">
                <div class="fade in" data-alerts="alerts" data-fade="3000"></div>
            </div>
        </div>
    </div>
</div>

<script src="/assets/jquery/jquery-2.2.3.min.js"></script>
<script async src="/assets/bootstrap/js/bootstrap.js"></script>
<script async src="/assets/ws/sockjs-0.3.4.js"></script>
<script async src="/assets/ws/stomp.js"></script>
<script async src="/assets/jquery/jquery.bsAlerts.min.js"></script>
<script async src="/assets/js/auth.js"></script>
<script async src="/assets/js/anon/room.js"></script>
</body>
</html>
