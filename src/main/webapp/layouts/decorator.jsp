<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ru" xmlns:sitemesh="sitemesh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="UTF-8">
    <title>Boltalka</title>
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap/fonts/glyphicons-halflings-regular.ttf"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap/css/bootstrap-theme.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/style/auth.css"/>">
</head>
<body id="body">
<script type="application/javascript">
    var context = '${pageContext.request.contextPath}';
</script>
<nav class="navbar navbar-default navbar-static-top" id="menu">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/"/>">Boltalka</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="${menuNews}"><a href="<c:url value="/news"/>">Новости</a></li>
                <li><a href="#">О нас</a></li>
                <li><a href="#">Контакты</a></li>
                <li><a href="<c:url value="/room"/>">Чаты</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="${menuLogin}"><a href="#" data-toggle="modal" data-target="#loginModal">Вход</a></li>
                <li class="${menuRegister}"><a href="<c:url value="/register"/>">Регистрация</a></li>
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

<script src="<c:url value="/assets/jquery/jquery-2.2.3.min.js"/>"></script>
<script async src="<c:url value="/assets/bootstrap/js/bootstrap.js"/>"></script>
<script async src="<c:url value="/assets/ws/sockjs-0.3.4.js"/>"></script>
<script async src="<c:url value="/assets/ws/stomp.js"/>"></script>
<script async src="<c:url value="/assets/jquery/jquery.bsAlerts.min.js"/>"></script>
<script async src="<c:url value="/assets/js/auth.js"/>"></script>
<script async src="<c:url value="/assets/js/anon/room.js"/>"></script>
</body>
</html>
