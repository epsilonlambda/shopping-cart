package ca.epsilonlambda.shoppingcart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kirill on 6/8/2016.
 */
@RestController
public class ProductsController {
    @RequestMapping("/api/v1/products")
    String get() {
        return "[]";
    }
}
