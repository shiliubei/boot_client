package app.api;

import app.model.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Service
public class ApiService {

    private RestTemplate restTemplate;

    public ApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .basicAuthentication("admin", "admin")
                .build();
    }

    public User getUserByName(String userName) {
        String URL = "http://localhost:8080/api/rest/userbyname/" + userName;
        return restTemplate.getForObject(URL, User.class, new User());
    }

    public List setRoles() {
        String URL = "http://localhost:8080/api/rest/roles";
        return restTemplate.getForObject(URL, List.class, new HashMap<>());
    }

    public List getUserList() {
        String URL = "http://localhost:8080/api/rest/userslist";
        return restTemplate.getForObject(URL, List.class, new HashMap<>());
    }

    public User getUserById(Integer id) {
        String URL = "http://localhost:8080/api/rest/user/" + id;
        return restTemplate.getForObject(URL, User.class, new User());
    }

    public ResponseEntity<User> addUser(User user) {
        String URL = "http://localhost:8080/api/rest/adduser";
        User result = restTemplate.postForObject(URL, user, User.class);
        return ResponseEntity.ok().body(result);
    }

    public ResponseEntity<User> editUser(User user) {
        String URL = "http://localhost:8080/api/rest/edituser";
        User result = restTemplate.postForObject(URL, user, User.class);
        return ResponseEntity.ok().body(result);
    }

    public ResponseEntity<String> deleteUser(Integer id) {
        String URL = "http://localhost:8080/api/rest/deleteuser/" + id;
        String result = restTemplate.getForObject(URL, String.class);
        return ResponseEntity.ok().body(result);
    }

}
