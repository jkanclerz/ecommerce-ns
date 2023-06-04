package pl.jkanclerz.sales;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OfferAcceptanceE2ETest {

    TestRestTemplate restTemplate;

    @Test
    void acceptOffer() {
        //Arrange
        String productId = thereIsProduct();
        String customerId = thereIsCustomer();
        restTemplate.postForEntity(String.format("/api/add-to-cart/", productId));
        restTemplate.postForEntity(String.format("/api/add-to-cart/", productId));

        AcceptOfferRequest request = new AcceptOfferRequest()
                .setEmail("jakub.guzik@gmail.com")
                .setFname("Jakub")
                .setLname("Guzik");

        ResponseEntity<ReservationDetails> response = restTemplate
                .postForEntity("/api/offer/accept", request, ReservationDetails.class);


        assertNotNull(response.getBody().getThankYouMessage());

    }
}
