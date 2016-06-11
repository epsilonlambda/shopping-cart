package ca.epsilonlambda.shoppingcart.data;

import ca.epsilonlambda.shoppingcart.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kirill on 6/11/2016.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {}
