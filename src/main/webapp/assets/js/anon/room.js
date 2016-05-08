var stompClient = null;
var roomName = document.getElementById('roomName');

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('disconnect').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('roomName').style.visibility = connected ? 'hidden' : 'visible';
    document.getElementById('connect').style.visibility = connected ? 'hidden' : 'visible';
}

function connect() {
    var socket = new SockJS('/anon');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/anon/' + roomName.value, function(text){
            showMessage(text.body);
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

function sendMessage() {
    var text = document.getElementById('text').value;
    $("#text").val("");
    stompClient.send("/app/anon/" + roomName.value, {},  text);
}

function showMessage(text) {
    $('#messages').append(
        '<div class="alert alert-success fade in">' +
        '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>' +
        ' ' + text +
        '</div>'
    );
    document.getElementById("messages").scrollTop = 9999;

}