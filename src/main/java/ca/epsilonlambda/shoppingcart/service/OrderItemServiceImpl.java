package ca.epsilonlambda.shoppingcart.service;

import ca.epsilonlambda.shoppingcart.data.OrderItemRepository;
import ca.epsilonlambda.shoppingcart.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kirill on 6/14/2016.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemRepository repository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrderItem> getItems(String userId) {
        return repository.findByOwner_Id(userId);
    }

    @Override
    public OrderItem getItem(String userId, int productId) {
        return repository.findFirstByOwner_IdAndProduct_Id(userId, productId);
    }

    @Override
    public void saveItem(OrderItem item) {
        repository.save(item);
    }

    @Override
    public void deleteItem(String userId, int productId) {
        OrderItem item = repository.findFirstByOwner_IdAndProduct_Id(userId, productId);
        repository.delete(item);
    }
}
