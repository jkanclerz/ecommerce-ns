package pl.jkanclerz.sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    void acceptOffer() {
        sales.acceptOffer(getCurrentCustomer());
    }

    private String getCurrentCustomer() {
        return "guest";
    }
}
