package pl.jkanclerz.catalog;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


// BIZNES
// TECH STORAGE

public class ProductCatalog {

    HashMapProductStorage storage;

    public ProductCatalog(HashMapProductStorage storage) {
        this.storage = storage;
    }

    public String createProduct(String name) {
        Product product = new Product(UUID.randomUUID(), name);
        storage.save(product);

        return product.getId();
    }

    public List<Product> allAvailableProducts() {
        return storage.allAvailableProducts();

    }

    public List<Product> allPublishedProducts() {
        return storage.allPublishedProducts();
    }

    public void changePrice(String productId, BigDecimal newPrice) {
        Product product = storage.load(productId)
                .orElseThrow(() -> new ProductDoesNotExistsException());

        product.changePrice(newPrice);

    }

    public Optional<Product> findProduct(String productId) {
        return storage.load(productId);
    }

    public void publish(String productId) {
        Product product = storage.load(productId)
                .orElseThrow(() -> new ProductDoesNotExistsException());

        if (product.getPrice() == null) {
            throw new CantPublishProductException();
        }

        product.publish();
    }
}
