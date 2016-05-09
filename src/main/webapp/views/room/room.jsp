<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
    <div class="container" onload="disconnect()">

        <div class="row">
            <input type="text" id="roomName" class="form-control" placeholder="Имя канала" required autofocus><br>
            <button class="btn btn-lg btn-primary" id="connect" onclick="connect();">Создать</button>
        </div>
        <div id="messages" style="height:450px;overflow:scroll; overflow-x:hidden;">

        </div>
        <div id="conversationDiv" style="visibility: hidden">
            <label for="text">Сообщение</label>
            <input class="form-control" type="text" id="text" maxlength="5000" autofocus/>
            <button class="btn btn-lg btn-primary" id="sendName" onclick="sendMessage();">Отправить</button>
            <button class="btn btn-lg btn-primary" id="disconnect" style="visibility: hidden" disabled="disabled" onclick="disconnect();">Выйти</button>
        </div>
    </div>

</div>