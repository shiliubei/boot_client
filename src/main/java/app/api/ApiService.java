package app.api;

import app.model.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private RestTemplate restTemplate;
    private HttpHeaders headers;

    public ApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                 .basicAuthentication("admin", "admin")
                .build();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public User getUserByName(String userName) {
        String URL = "http://localhost:8080/admin/rest/userbyname/" + userName;
//        HttpEntity<User> request = new HttpEntity<>(headers);

        ResponseEntity<User> response = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<User>() {
                });
        return response.getBody();
    }

}
