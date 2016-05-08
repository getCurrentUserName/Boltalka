<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.boltalka.components.enums.CommandStatus" %>
<div class="content">
    <div class="form-register">
        <form id="register">
            <h2 class="form-register-heading">Регистрация</h2>
            <h4 class="form-register-heading">Это бесплатно и всегда будет бесплатнo.</h4>
            <input type="text" name="username" class="form-control" placeholder="Логин" required autofocus>
            <input type="text" name="nickname" class="form-control" placeholder="Никнейм" required>
            <input type="password" name="password" class="form-control input-password" placeholder="Пароль" required>
            <input type="password" name="password2" class="form-control input-password2" placeholder="Повторите пароль" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Регистрация</button>
        </form>
    </div>
    <div class="toblur">
        <div class="fade in" data-alerts="alerts" data-fade="3000"></div>
    </div>
    <%
        String success = CommandStatus.SUCCESS.name();
        request.setAttribute("SUCCESS", success);
        String error = CommandStatus.ERROR.name();
        request.setAttribute("ERROR", error);
        String usernameExist = CommandStatus.USERNAME_EXIST.name();
        request.setAttribute("USERNAME_EXIST", usernameExist);
        String invalid = CommandStatus.PASSWORD_INVALID.name();
        request.setAttribute("PASSWORD_INVALID", invalid);
    %>
    <c:choose>
        <c:when test="${result == SUCCESS}">
            <div class="alert alert-success">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Успешно!</strong> Поздравляем с успешной регистрацией
            </div>
            <script type="application/javascript">
                window.onload = function() {
                    loginRequest('${username}', '${password}');
                }
            </script>
        </c:when>
        <c:when test="${result == ERROR}">
            <div class="alert alert-danger">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Ошибка!</strong> Произошла неизвестная ошибка
            </div>
        </c:when>
        <c:when test="${result == USERNAME_EXIST}">
            <div class="alert alert-danger">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Ошибка!</strong> Имя пользователя занято
            </div>
        </c:when>
        <c:when test="${result == PASSWORD_INVALID}">
            <div class="alert alert-danger">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Ошибка!</strong> Пароли не совпадают
            </div>
        </c:when>
    </c:choose>
</div>
