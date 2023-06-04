package pl.jkanclerz.payu;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Payu {

    RestTemplate http;

    public Payu(RestTemplate http) {
        this.http = http;
    }

    public OrderCreateResponse handle(OrderCreateRequest orderCreateRequest) {
        String url = "https://secure.snd.payu.com/api/v2_1/orders";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", getToken());

        HttpEntity<OrderCreateRequest> request = new HttpEntity<>(orderCreateRequest, headers);

        ResponseEntity<OrderCreateResponse> response = http.postForEntity(url, request, OrderCreateResponse.class);

        return response.getBody();
    }

    private String getToken() {
        return "Bearer d9a4536e-62ba-4f60-8017-6053211d3f47";
    }
}
