package ca.epsilonlambda.shoppingcart.service;

import ca.epsilonlambda.shoppingcart.domain.User;

/**
 * Created by Kirill on 6/13/2016.
 */
public interface UserTokenService {
    String getAuthToken(User user);
    User getUserFromToken(String token);
}
