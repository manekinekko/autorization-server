package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Controller
@SessionAttributes("authorizationRequest")
public class AuthserverApplication extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(AuthserverApplication.class, args);
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/oauth/confirm_access").setViewName("authorize");
  }

  @Configuration
  @Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
  protected static class LoginConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.formLogin().loginPage("/login").permitAll().and().authorizeRequests().anyRequest().authenticated();
      http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.parentAuthenticationManager(authenticationManager);
    }

  }

  @Configuration
  @EnableAuthorizationServer
  protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter  {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public JwtAccessTokenConverter symmetricAccessTokenConverter() {
      // JwtAccessTokenConverter converter = new CustomTokenEnhancer();
      JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
      converter.setSigningKey("demo-client-123xyz");
      return converter;
    }
    
    // @Bean
    // public JwtAccessTokenConverter asymmetricAccessTokenConverter() {
    //   JwtAccessTokenConverter converter = new CustomTokenEnhancer();
    //   KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "foobar".toCharArray()).getKeyPair("test");
    //   converter.setKeyPair(keyPair);
    //   return converter;
    // }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      clients.inMemory()
          .withClient("demo-client-123xyz")
          .secret("demo-client-123xyz")
          .accessTokenValiditySeconds(7200) // 2 hours in seconds
          .resourceIds("oauth2-ressource")
          .authorizedGrantTypes("implicit", "authorization_code", "refresh_token", "password")
          .scopes("name", "email", "profile", "calendar");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

      endpoints
        .authenticationManager(authenticationManager)
        .accessTokenConverter(symmetricAccessTokenConverter());
        // .accessTokenConverter(symmetricAccessTokenConverter());

   }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
      oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

  }
}
