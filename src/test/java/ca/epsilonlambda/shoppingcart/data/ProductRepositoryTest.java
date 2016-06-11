package ca.epsilonlambda.shoppingcart.data;

import ca.epsilonlambda.shoppingcart.Runner;
import ca.epsilonlambda.shoppingcart.domain.Product;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Kirill on 6/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Runner.class)
public class ProductRepositoryTest extends TestCase {

    @Autowired
    ProductRepository repository;

    @Test
    public void insertAndRetrieve() {
        final String testName = "testName";
        final String testDescription = "testDescription";

        Product p = new Product(testName, testDescription, 1);
        repository.save(p);

        for(Product product : repository.findAll()) {
            if(product.getName().equals(testName) &&
                    product.getDescription().equals(testDescription) &&
                    product.getCost() == 1) {
                assertTrue(true);
                return;
            }
        }

        fail();
    }
}
