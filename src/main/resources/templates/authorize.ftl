<!doctype html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <link rel="stylesheet" href="/css/wro.css" />
</head>

<body>
    <div class="container">
        <h2>Please Confirm</h2>

        <p>
            Do you authorize <b>${authorizationRequest.clientId}</b> at <b>${authorizationRequest.redirectUri}</b> to access your protected resources with scopes:
            <ul>
                <#list authorizationRequest.scope as scope>
                    <li><b>${scope}</b></li>
                </#list>
            </ul>
        </p>
        <form id="confirmationForm" name="confirmationForm" action="/oauth/authorize" method="post">
            <input name="user_oauth_approval" value="true" type="hidden" />
            <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="btn btn-primary" type="submit">Approve</button>
        </form>
        <form id="denyForm" name="confirmationForm" action="/oauth/authorize" method="post">
            <input name="user_oauth_approval" value="false" type="hidden" />
            <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="btn btn-primary" type="submit">Deny</button>
        </form>
    </div>
    <script src="/js/wro.js" type="text/javascript"></script>
</body>

</html>