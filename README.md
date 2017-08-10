This project is a simple, minimal implementation of an OAuth2 Authorization Server. 
It has a context root of `/`.

OAuth2 endpoints are:

* `/oauth/token` the Token endpoint, for clients to acquire access
  tokens. There is one client: `demo-client-123xyz` with secret `demo-client-123xyz`.

* `/oauth/authorize` the Authorization endpoint to obtain user
  approval for a token grant.

* `/oauth/check_token` the Check Token endpoint (not part of the
  OAuth2 spec). Can be used to decode a token remotely.

* User login and password are: `user:password`

More information about Spring Security OAuth2 [here](https://github.com/spring-projects/spring-security-oauth/blob/master/docs/oauth2.md)