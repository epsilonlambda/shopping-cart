package ca.epsilonlambda.shoppingcart.integration;

import ca.epsilonlambda.shoppingcart.Runner;
import ca.epsilonlambda.shoppingcart.domain.Product;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

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

    @Test
    public void testGet() {
        Product[] products = restTemplate.getForEntity("http://localhost:" + port + "/api/v1/products", Product[].class).getBody();
        assertTrue(products.length > 0);
    }

}
