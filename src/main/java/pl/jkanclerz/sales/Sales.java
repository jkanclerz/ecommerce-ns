package pl.jkanclerz.sales;

import pl.jkanclerz.payu.OrderCreateRequest;
import pl.jkanclerz.payu.OrderCreateResponse;
import pl.jkanclerz.payu.Payu;

public class Sales {
    Payu payu;

    public void addToCart(String customerId, String productId) {

    }

    public Offer getCurrentOffer(String customerId) {
        return null;

    }

    public ReservationDetails acceptOffer(String customerId, AcceptOfferRequest acceptOffer) {
        Offer toBeCheckouted = this.getCurrentOffer(customerId);

        OrderCreateRequest orderCreateRequest = new OrderCreateRequest();
        //
        OrderCreateResponse resp = payu.handle(orderCreateRequest);

        return new ReservationDetails(resp.getRedirectUri());
    }
}
