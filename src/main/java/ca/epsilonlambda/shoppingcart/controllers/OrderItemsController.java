package ca.epsilonlambda.shoppingcart.controllers;

import ca.epsilonlambda.shoppingcart.domain.OrderItem;
import ca.epsilonlambda.shoppingcart.domain.User;
import ca.epsilonlambda.shoppingcart.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Kirill on 6/14/2016.
 */
@RestController
public class OrderItemsController {
    final static String ENDPOINT = "/api/v1/ordered_products";

    private OrderItemService orderItemService;


    @Autowired
    public OrderItemsController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @RequestMapping(ENDPOINT)
    public List<OrderItem> getAll(Principal principal) {
        User user = getUser(principal);
        return orderItemService.getItems(user.getId());
    }

    @RequestMapping(value = (ENDPOINT + "/{productId}"), method = { RequestMethod.PUT })
    public OrderItem putOrderItem(Principal principal, @PathVariable("productId") int productId, @RequestBody OrderItem newItem) {
        User user = getUser(principal);
        OrderItem item = orderItemService.getItem(user.getId(), productId);
        item.setQuantity(newItem.getQuantity());

        return orderItemService.saveItem(item);
    }

    @RequestMapping(value = (ENDPOINT + "/{productId}"), method = { RequestMethod.POST })
    public OrderItem postItem(Principal principal, @PathVariable("productId") int productId, @RequestBody OrderItem newItem) {
        User user = getUser(principal);
        return orderItemService.saveItem(newItem);
    }

    @RequestMapping(value = (ENDPOINT + "/{productId}"), method = { RequestMethod.DELETE })
    public void deleteOrderItem(Principal principal, @PathVariable("productId") int productId) {
        User user = getUser(principal);
        orderItemService.deleteItem(user.getId(), productId);
    }

    private User getUser(Principal principal) {
        return (User) ((Authentication) principal).getPrincipal();
    }

}
