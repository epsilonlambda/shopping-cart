package ca.epsilonlambda.shoppingcart.service;

import ca.epsilonlambda.shoppingcart.domain.Product;

import java.util.Collection;

/**
 * Created by Kirill on 6/11/2016.
 */
public interface ProductService {
    Collection<Product> findAllProducts();
}
