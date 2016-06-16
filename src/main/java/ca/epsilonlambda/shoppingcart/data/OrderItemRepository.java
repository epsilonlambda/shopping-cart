package ca.epsilonlambda.shoppingcart.data;

import ca.epsilonlambda.shoppingcart.domain.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Kirill on 6/14/2016.
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
    OrderItem findFirstByOwner_IdAndProduct_Id(String ownerUserId, int productId);
    List<OrderItem> findByOwner_Id(String ownerUserId);
}
