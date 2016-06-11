package ca.epsilonlambda.shoppingcart.controllers;

import ca.epsilonlambda.shoppingcart.domain.Product;
import ca.epsilonlambda.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Kirill on 6/8/2016.
 */
@RestController
public class ProductsController {
    private ProductService service;

    @Autowired
    public ProductsController(ProductService service) {
        this.service = service;
    }

    @RequestMapping("/api/v1/products")
    Collection<Product> get() {
        return service.findAllProducts();
    }
}
