package ca.epsilonlambda.shoppingcart.service;

import ca.epsilonlambda.shoppingcart.data.UserRepository;
import ca.epsilonlambda.shoppingcart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Kirill on 6/12/2016.
 */
@Service
public class UserServiceImpl implements UserService {
    final String ANONYMOUS_USER_PREFIX = "anon-";

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    private User createAnonymousUser() {
        String userId = ANONYMOUS_USER_PREFIX + UUID.randomUUID().toString();
        return new User(userId);
    }

    @Override
    public User createAndStoreAnonymousUser() {
        return repository.save(createAnonymousUser());
    }
}
