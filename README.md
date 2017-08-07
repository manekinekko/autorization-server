This project is a simple, minimal implementation of an OAuth2 Authorization Server. 
It has a context root of `/uaa` (so that it won't share cookies with other apps
running on other ports on the root resource). 

OAuth2 endpoints are:

* `/uaa/oauth/token` the Token endpoint, for clients to acquire access
  tokens. There is one client: `demo-client-123xyz` with secret `demo-client-123xyz`.

* `/uaa/oauth/authorize` the Authorization endpoint to obtain user
  approval for a token grant.

* `/uaa/oauth/check_token` the Check Token endpoint (not part of the
  OAuth2 spec). Can be used to decode a token remotely.

* User login and password are: `user:password`
