package ca.epsilonlambda.shoppingcart.integration;

import ca.epsilonlambda.shoppingcart.Runner;
import ca.epsilonlambda.shoppingcart.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
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
            String token = restTemplate.postForEntity("http://localhost:" + port + "/api/v1/rpc/anonymous_login", null, String.class).getBody();
            Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
            String userId = claims.getSubject();
            assertFalse(ids.contains(userId));
            ids.add(userId);
        }

        assertTrue(ids.size() > 0);
    }

    @Test
    public void testMeEndpoint() {
        String token = restTemplate.postForEntity("http://localhost:" + port + "/api/v1/rpc/anonymous_login", null, String.class).getBody();
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        String userId = claims.getSubject();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<User> rsp = restTemplate.exchange("http://localhost:" + port + "/api/v1/me",HttpMethod.GET, requestEntity, User.class);
        User user = rsp.getBody();
        assertEquals(userId, user.getId());
    }
}
