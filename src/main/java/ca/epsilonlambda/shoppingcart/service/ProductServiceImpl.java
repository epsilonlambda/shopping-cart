package ca.epsilonlambda.shoppingcart.service;

import ca.epsilonlambda.shoppingcart.data.ProductRepository;
import ca.epsilonlambda.shoppingcart.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Kirill on 6/11/2016.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Product> findAllProducts() {
        ArrayList<Product> products = new ArrayList<>();

        for(Product p : repository.findAll()){
            products.add(p);
        }

       return products;
    }
}
