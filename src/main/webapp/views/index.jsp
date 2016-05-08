<div class="mdl-card" onload="disconnect()">
    <div class="mdl-card__title">
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="connect" onclick="connect();">Connect</button>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div class="mdl-card__media" style="height: 200px;">
        <p class="mdl-card__actions" id="response"></p>
    </div>
    <div class="mdl-card__actions" id="conversationDiv">
        <label for="name">What is your name?</label>
        <input class="mdl-textfield__input" type="text" id="name" />
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="sendName" onclick="sendName();">Send</button>
    </div>
</div>
<script type="text/javascript">
    var stompClient = null;

    function setConnected(connected) {
        document.getElementById('connect').disabled = connected;
        document.getElementById('disconnect').disabled = !connected;
        document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
        document.getElementById('response').innerHTML = '';
    }

    function connect() {
        var socket = new SockJS('/hello');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/greetings', function(greeting){
                showGreeting(JSON.parse(greeting.body).content);
            });
        });
    }

    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log("Disconnected");
    }

    function sendName() {
        var name = document.getElementById('name').value;
        stompClient.send("/app/hello", {}, JSON.stringify({ 'name': name }));
    }

    function showGreeting(message) {
        var response = document.getElementById('response');
        var p = document.createElement('p');
        p.style.wordWrap = 'break-word';
        p.appendChild(document.createTextNode(message));
        response.appendChild(p);
    }
</script>