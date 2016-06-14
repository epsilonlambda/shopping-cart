package ca.epsilonlambda.shoppingcart.security;

import ca.epsilonlambda.shoppingcart.domain.User;
import ca.epsilonlambda.shoppingcart.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kirill on 6/14/2016.
 */
public class UserTokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    @Autowired
    UserTokenService tokenService;

    protected UserTokenAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    protected UserTokenAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String authHeader = request.getHeader("Authentication");
        String token = authHeader.replace("Bearer", "").trim();

        User user = tokenService.getUserFromToken(token);

        if(user != null) {
            return new UsernamePasswordAuthenticationToken(user, null);
        }

        return null;
    }
}
