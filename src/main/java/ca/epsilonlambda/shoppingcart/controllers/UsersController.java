package ca.epsilonlambda.shoppingcart.controllers;

import ca.epsilonlambda.shoppingcart.domain.User;
import ca.epsilonlambda.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kirill on 6/13/2016.
 */
@RestController
public class UsersController {
    private UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/api/v1/anonymous_login")
    public String anonymousLogin() {
        User user = service.createAndStoreAnonymousUser();
        return user.getId();
    }
}
