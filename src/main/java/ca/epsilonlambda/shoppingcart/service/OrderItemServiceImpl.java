package ca.epsilonlambda.shoppingcart.service;

import ca.epsilonlambda.shoppingcart.data.OrderItemRepository;
import ca.epsilonlambda.shoppingcart.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<OrderItem> items = repository.findByOwner_Id(userId);
        List<OrderItem> pendingItems = new ArrayList<>();
        for(OrderItem item : items) {
            if(!item.isSubmitted())
                pendingItems.add(item);
        }

        return pendingItems;
    }

    @Override
    public OrderItem getItem(String userId, int productId) {
        return repository.findFirstByOwner_IdAndProduct_Id(userId, productId);
    }

    @Override
    public OrderItem saveItem(OrderItem item) {
        return repository.save(item);
    }

    @Override
    public void deleteItem(String userId, int productId) {
        OrderItem item = repository.findFirstByOwner_IdAndProduct_Id(userId, productId);
        repository.delete(item);
    }

    @Override
    public void submitItems(String userId) {
        List<OrderItem> items = repository.findByOwner_Id(userId);
        for(OrderItem item : items) {
            if(!item.isSubmitted()){
                item.setSubmitted(true);
            }
        }

        repository.save(items);
    }
}
