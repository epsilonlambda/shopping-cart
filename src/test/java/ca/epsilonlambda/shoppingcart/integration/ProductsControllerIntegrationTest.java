package ca.epsilonlambda.shoppingcart.integration;

import ca.epsilonlambda.shoppingcart.Runner;
import ca.epsilonlambda.shoppingcart.domain.Product;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Kirill on 6/11/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Runner.class)
@WebIntegrationTest
public class ProductsControllerIntegrationTest extends TestCase {

    RestTemplate restTemplate = new TestRestTemplate();


    @Value("${local.server.port}")
    int port;

    HttpEntity<String> emptyRequestEntity;

    @Before
    public void setUp() {
        String token = restTemplate.postForEntity("http://localhost:" + port + "/api/v1/rpc/anonymous_login", null, String.class).getBody();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        emptyRequestEntity = new HttpEntity<>(headers);
    }

    @Test
    public void testGet() {
        Product[] products = restTemplate.exchange("http://localhost:" + port + "/api/v1/products", HttpMethod.GET, emptyRequestEntity, Product[].class).getBody();
        assertTrue(products.length > 0);
    }

}
