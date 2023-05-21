package pl.jkanclerz.catalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CatalogE2ETest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate http;

    @Test
    void productListing() {
        //Arrange
        //przegladarka // client http // curl / chrome
        String url = String.format("http://localhost:%s/api/products", port);

        //Act
        // otworz URL http://localhost:port/api/products
        ResponseEntity<Object[]> resp = http.getForEntity(url, Object[].class);

        //Assert
        //status code 200
        //constains name
        assert resp.getStatusCode().equals(HttpStatus.OK);
    }
}
