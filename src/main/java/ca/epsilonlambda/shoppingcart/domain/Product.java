package ca.epsilonlambda.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Kirill on 6/11/2016.
 */
@Entity
public class Product {
    @GeneratedValue
    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String image;

    public Product(String name, String description, float cost, String image) {
        this.name = name;
        this.description = description;
        this.price = cost;
        this.image = image;
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

}
