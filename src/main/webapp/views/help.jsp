<div class="mdl-card" onload="disconnect()">
    <div class="mdl-card__media" style="height: 200px;">
        <p class="mdl-card__actions" id="response"></p>
    </div>
    <div class="mdl-card__actions" id="conversationDiv">
        <label for="name">What news?</label>
        <input class="mdl-textfield__input" type="text" id="name" />
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" id="sendName" onclick="sendName();">Send</button>
    </div>
</div>