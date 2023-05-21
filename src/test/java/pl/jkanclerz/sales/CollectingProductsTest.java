package pl.jkanclerz.sales;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CollectingProductsTest {
    @Test
    void itAllowsToCollectProducts() {
        //A
        String customerId = thereIsCustomer("Kuba");
        String productId = thereIsProduct();
        Sales sales = thereIsSalesModule();
        //A
        sales.addToCart(customerId, productId);
        //A
        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(1, offer.getItemsCount());
        assertEquals(BigDecimal.valueOf(100), offer.getTotal());
    }

    @Test
    void offerIsAcceptable() {
        String customerId = thereIsCustomer("Kuba");
        String productId = thereIsProduct();
        Sales sales = thereIsSalesModule();

        sales.addToCart(customerId, productId);
        sales.acceptOffer(customerId);

        asserThereIsReservationCreatedWithinTheSystemForCustomer(customerId);
    }

    private void asserThereIsReservationCreatedWithinTheSystemForCustomer(String customerId) {

    }

    private Sales thereIsSalesModule() {
        return new Sales();
    }

    private String thereIsProduct() {
        return UUID.randomUUID().toString();
    }

    private String thereIsCustomer(String id) {
        return id;
    }
}
