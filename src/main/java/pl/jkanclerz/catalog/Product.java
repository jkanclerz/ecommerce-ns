package pl.jkanclerz.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String uuid;
    private final String name;
    private BigDecimal price;
    private boolean online;

    public Product(UUID uuid, String name) {
        this.uuid = uuid.toString();
        this.name = name;
    }

    public String getId() {
        return uuid;
    }

    public void changePrice(BigDecimal newPrice) {
        this.price = newPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void publish() {
        this.online = true;
    }

    public boolean isOnline() {
        return online;
    }


    public String getName() {
        return name;
    }
}
