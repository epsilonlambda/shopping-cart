package ca.epsilonlambda.shoppingcart.service;

import ca.epsilonlambda.shoppingcart.domain.User;

/**
 * Created by Kirill on 6/12/2016.
 */
public interface UserService {
    User createAndStoreAnonymousUser();
}
