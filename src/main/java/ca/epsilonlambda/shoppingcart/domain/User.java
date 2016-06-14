package ca.epsilonlambda.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Kirill on 6/12/2016.
 */
@Entity
public class User {
    @Id
    private String id;

    public User() {}

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User && ((User) obj).id == id;
    }
}
