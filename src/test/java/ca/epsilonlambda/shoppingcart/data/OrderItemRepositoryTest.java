package ca.epsilonlambda.shoppingcart.data;

import ca.epsilonlambda.shoppingcart.Runner;
import ca.epsilonlambda.shoppingcart.domain.OrderItem;
import ca.epsilonlambda.shoppingcart.domain.Product;
import ca.epsilonlambda.shoppingcart.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kirill on 6/14/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Runner.class)
@EnableWebSecurity
public class OrderItemRepositoryTest {
    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    final User sampleUser = new User("Kirill");

    final Product sampleProduct = new Product("RepoTestProduct1", "This is a test", 55, "");

    @Before
    public void setUp() {
        userRepository.save(sampleUser);
        productRepository.save(sampleProduct);
        orderItemRepository.save(new OrderItem(sampleUser, sampleProduct, 11));
    }

    @After
    public void tearDown() {
        orderItemRepository.deleteAll();
        userRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void shouldFindAllItemsForUser() {
        List<OrderItem> items = orderItemRepository.findByOwner_Id(sampleUser.getId());
        assertEquals(1, items.size());

        OrderItem item1 = items.get(0);
        assertEquals(sampleUser, item1.getOwner());
        assertEquals(sampleProduct.getId(), item1.getProduct().getId());
        assertEquals(11, item1.getQuantity());
    }

    @Test
    public void shouldFindOrderedItemForUser() {
        OrderItem item1 = orderItemRepository.findFirstByOwner_IdAndProduct_Id(sampleUser.getId(), sampleProduct.getId());
        assertEquals(sampleUser, item1.getOwner());
        assertEquals(sampleProduct.getId(), item1.getProduct().getId());
        assertEquals(11, item1.getQuantity());
    }
}
