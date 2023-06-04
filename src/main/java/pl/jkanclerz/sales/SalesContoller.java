package pl.jkanclerz.sales;

import org.springframework.web.bind.annotation.*;

@RestController
public class SalesContoller {

    Sales sales;

    public SalesContoller(Sales sales) {
        this.sales = sales;
    }

    @GetMapping("/api/offer")
    Offer getCurrentOffer() {
        return sales.getCurrentOffer(getCurrentCustomer());
    }
    @PostMapping("/api/cart/{productId}")
    void addToCart(@PathVariable String productId) {
        sales.addToCart(getCurrentCustomer(), productId);
    }
    @PostMapping("/api/offer/accept")
    ReservationDetails acceptOffer(@RequestBody AcceptOfferRequest acceptOfferRequest) {
        return sales.acceptOffer(getCurrentCustomer(), acceptOfferRequest);
    }

    private String getCurrentCustomer() {
        return "guest";
    }
}
