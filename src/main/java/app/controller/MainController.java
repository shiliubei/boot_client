package app.controller;


import app.model.Role;
import app.model.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MainController {

    private final RestTemplate template;

    public MainController(RestTemplateBuilder restTemplateBuilder) {
        this.template = restTemplateBuilder
                .basicAuthentication("admin", "admin")
                .build();
    }

    @GetMapping("/rest/users")
    public ResponseEntity<List<User>> listCustomers() {
        String URL = "http://localhost:8080/admin/rest/userslist";
        ResponseEntity<List<User>> response = template.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                });
        return response;
    }

    @GetMapping("/rest/roles")
    public ResponseEntity<List<Role>> rolesSet() {
        String URL = "http://localhost:8080/admin/rest/roles";
        ResponseEntity<List<Role>> response = template.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Role>>() {
                });
        return response;
    }

    @GetMapping("/rest/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        String URL = "http://localhost:8080/admin/rest/user/" + id;

        ResponseEntity<User> response = template.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<User>() {
                });
        return response;
    }

    @PostMapping(value = "/rest/adduser", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> add(@RequestBody User user) {
        String URL = "http://localhost:8080/admin/rest/adduser";
        User result = template.postForObject(URL, user, User.class);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/rest/edituser", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> edit(@RequestBody User user) {
        String URL = "http://localhost:8080/admin/rest/edituser";
        User result = template.postForObject(URL, user, User.class);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/rest/deleteuser/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        String URL = "http://localhost:8080/admin/rest/deleteuser/" + id;
        String result = template.getForObject(URL, String.class);
        return ResponseEntity.ok().body(result);
    }
}
