package ca.epsilonlambda.shoppingcart.service;

import ca.epsilonlambda.shoppingcart.Runner;
import ca.epsilonlambda.shoppingcart.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * Created by Kirill on 6/14/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Runner.class)
@EnableWebSecurity
public class TokenServiceTest {
    @Autowired
    UserTokenService tokenService;

    User u;

    @Before
    public void setUp() {
        u = new User("kirill");
    }

    @Test
    public void shouldDecodeEncodedToken() {
        assertEquals(u.getId(), tokenService.getUserFromToken(tokenService.getAuthToken(u)).getId());
    }
}
