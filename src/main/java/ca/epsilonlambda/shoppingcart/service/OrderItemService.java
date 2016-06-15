package ca.epsilonlambda.shoppingcart.service;

import ca.epsilonlambda.shoppingcart.domain.OrderItem;

import java.util.List;

/**
 * Created by Kirill on 6/14/2016.
 */
public interface OrderItemService {
    List<OrderItem> getItems(String userId);
    OrderItem getItem(String userId, int productId);
    void saveItem(OrderItem item);
    void deleteItem(String userId, int productId);
}
