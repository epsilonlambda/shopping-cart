package ca.epsilonlambda.shoppingcart;

import ca.epsilonlambda.shoppingcart.security.UserTokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Kirill on 6/14/2016.
 */
@Component
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserTokenAuthenticationFilter tokenAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/api/v1/products", "/api/v1/rpc/anonymous_login").anonymous().and().csrf().disable()
                .authorizeRequests().antMatchers("/api/v1/**").authenticated().and().addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
