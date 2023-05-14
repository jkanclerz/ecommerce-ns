package pl.jkanclerz.catalog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest {

    @Test
    void itAllowsToAddProduct() {
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();

        //act
        String productId = catalog.createProduct("Lego Set");

        //Assert
        List<Product> products = catalog.allAvailableProducts();
        List<Product> publishedProducts = catalog.allPublishedProducts();
        assert products.size() == 1;
        assert publishedProducts.size() == 0;
    }

    @Test
    void itAllowsToModifyPrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.createProduct("Lego Set");

        catalog.changePrice(productId, BigDecimal.valueOf(20.20));

        Product loaded = catalog.findProduct(productId).get();

        assert loaded.getPrice().equals(BigDecimal.valueOf(20.20));
    }
    @Test
    void itDennyPublicationWithoutPriceAndAttributes() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.createProduct("Lego Set");

        assertThrows(CantPublishProductException.class, () -> catalog.publish(productId));
    }

    @Test
    void itAllowProductPublication() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.createProduct("Lego Set");
        catalog.changePrice(productId, BigDecimal.valueOf(20.20));
        catalog.publish(productId);

        List<Product> publishedProducts = catalog.allPublishedProducts();
        assert publishedProducts.size() == 1;
    }



    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog(new HashMapProductStorage());
    }
}
