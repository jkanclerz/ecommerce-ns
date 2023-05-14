package pl.jkanclerz.catalog;

import java.util.List;
import java.util.Optional;

public interface ProductStorage {
    void save(Product product);

    List<Product> allAvailableProducts();

    List<Product> allPublishedProducts();

    Optional<Product> load(String productId);
}
