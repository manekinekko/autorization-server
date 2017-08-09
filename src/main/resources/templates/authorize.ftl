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
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Creativity Assistant</h2>
        </div>
        <div class="mdl-card__supporting-text">
            <p>
                Do you authorize <b>Creativity Assistant</b> to access your profile with scopes:
            </p>
            <ul class="mdl-list" style="margin: 0;padding: 0;">
                <#list authorizationRequest.scope as scope>
                    <li class="mdl-list__item" style="min-height: 10px;padding: 12px;"><b>${scope}</b></li>
                </#list>
            </ul>
        </div>
        <form name="confirmationForm" action="/oauth/authorize" method="post" class="mdl-card__actions mdl-card--border" style="display: flex;justify-content: space-between;">
            <input name="user_oauth_approval" value="true" type="hidden" />
            <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit">DECLINE</button>
            <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" type="submit">AUTHORIZE</button>
        </form>
    </div>
</body>

</html>