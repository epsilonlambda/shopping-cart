package ca.epsilonlambda.shoppingcart.domain;

import javax.persistence.*;

/**
 * Created by Kirill on 6/14/2016.
 */
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private User owner;

    @OneToOne
    private Product product;

    @Column(nullable = false)
    private int quantity;

    public OrderItem() {}

    public OrderItem(User owner, Product product, int quantity) {
        this.owner = owner;
        this.product = product;
        this.quantity = quantity;
    }

    public User getOwner() {
        return owner;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
