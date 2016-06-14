package ca.epsilonlambda.shoppingcart.controllers;

import ca.epsilonlambda.shoppingcart.domain.User;
import ca.epsilonlambda.shoppingcart.service.UserService;
import ca.epsilonlambda.shoppingcart.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kirill on 6/13/2016.
 */
@RestController
public class UsersController {
    private UserService userService;
    private UserTokenService tokenService;

    @Autowired
    public UsersController(UserService service, UserTokenService tokenService) {
        this.userService = service;
        this.tokenService = tokenService;
    }

    @RequestMapping("/api/v1/anonymous_login")
    public String anonymousLogin() {
        User user = userService.createAndStoreAnonymousUser();
        return tokenService.getAuthToken(user);
    }
}
