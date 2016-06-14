package ca.epsilonlambda.shoppingcart.data;

import ca.epsilonlambda.shoppingcart.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kirill on 6/12/2016.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
