package pl.jkanclerz.catalog;

import org.junit.jupiter.api.Test;

public class ListProductStorageTest {
    @Test
    void itCanStoreProduct() {
        ProductStorage storage = thereIsListProductStorage();
        Product product = exampleProduct();

        storage.save(product);

        Product loaded = storage.load(product.getId()).get();

        assert loaded.getId().equals(product.getId());
    }

    private Product exampleProduct() {
        return null;
    }

    private ProductStorage thereIsListProductStorage() {
        return new ListProductStorage();
    }
}
