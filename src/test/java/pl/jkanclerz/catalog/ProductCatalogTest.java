package pl.jkanclerz.catalog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ProductCatalogTest {

    @Test
    void itAllowsToAddProduct() {
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();

        //act
        String productId = thereIsProduct(catalog);

        //Assert
        List<Product> products = catalog.allAvailableProducts();
        List<Product> publishedProducts = catalog.allPublishedProducts();

        //assert products.size() == 1;
        // vs
        assertThat(products)
                .hasSize(1);

        assertEquals(0, publishedProducts.size(), "Product should not be published without metadata");
    }

    @Test
    void itAllowsToModifyPrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = thereIsProduct(catalog);

        catalog.changePrice(productId, BigDecimal.valueOf(20.20));

        Product loaded = catalog.findProduct(productId).get();

        assert loaded.getPrice().equals(BigDecimal.valueOf(20.20));
    }

    private String thereIsProduct(ProductCatalog catalog) {
        return catalog.createProduct("Lego Set");
    }

    @Test
    void itDennyPublicationWithoutPriceAndAttributes() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = thereIsProduct(catalog);

        assertThrows(CantPublishProductException.class, () -> catalog.publish(productId));
    }

    @Test
    void itAllowProductPublication() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = thereIsProduct(catalog);
        catalog.changePrice(productId, BigDecimal.valueOf(20.20));
        catalog.publish(productId);

        List<Product> publishedProducts = catalog.allPublishedProducts();
        assert publishedProducts.size() == 1;
    }



    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog(new HashMapProductStorage());
    }
}
