<!doctype html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="/css/wro.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <script defer="" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</head>

<body>
    <div class="mdl-card mdl-shadow--2dp" style="margin: 10px auto;">
        <form role="form" action="/login" method="post">
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">Creativity Assistant</h2>
            </div>
            <div class="mdl-card__supporting-text">
                <p>Login to <b>Creativity Assistant</b> to coninue...</p>
                <p>
                </p>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="username">
                    <label class="mdl-textfield__label" for="username">Username</label>
                </div>
                <p></p>
                <p>
                </p>
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="password" id="password">
                    <label class="mdl-textfield__label" for="password">Password</label>
                </div>
                <p></p>
            </div>
            <div class="mdl-card__actions mdl-card--border">
                <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">LOGIN</button>
            </div>
            <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </div>
</body>

</html>