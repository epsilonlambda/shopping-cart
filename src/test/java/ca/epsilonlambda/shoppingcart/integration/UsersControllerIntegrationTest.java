package ca.epsilonlambda.shoppingcart.integration;

import ca.epsilonlambda.shoppingcart.Runner;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Kirill on 6/13/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Runner.class)
@WebIntegrationTest
public class UsersControllerIntegrationTest {
    RestTemplate restTemplate = new TestRestTemplate();


    @Value("${local.server.port}")
    int port;

    @Value("${ca.epsilonlambda.shoppingcart.jwt_secret_key}")
    String jwtSecret;


    @Test
    public void anonymousLoginShouldGenerateDifferentIds() {
        HashSet<String> ids = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            String token = restTemplate.getForEntity("http://localhost:" + port + "/api/v1/anonymous_login", String.class).getBody();
            Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
            String userId = claims.getSubject();
            assertFalse(ids.contains(userId));
            ids.add(userId);
        }

        assertTrue(ids.size() > 0);
    }
}
