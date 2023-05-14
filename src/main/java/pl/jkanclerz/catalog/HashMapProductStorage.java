package pl.jkanclerz.catalog;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HashMapProductStorage implements ProductStorage {
    private HashMap<String, Product> products;

    public HashMapProductStorage() {
        this.products = new HashMap<>();
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public List<Product> allAvailableProducts() {
        return products.values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> allPublishedProducts() {
        return products.values()
                .stream()
                .filter(Product::isOnline)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> load(String productId) {
        return Optional.ofNullable(products.get(productId));
    }
}
