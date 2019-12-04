package app.controller;


import app.api.ApiService;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class MainController {

    private final ApiService apiService;

    public MainController( ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/rest/users")
    public List usersList() {
        return apiService.getUserList();
    }

    @GetMapping("/rest/roles")
    public List rolesSet() {
        return apiService.setRoles();
    }

    @GetMapping("/rest/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return apiService.getUserById(id);
    }

    @PostMapping(value = "/rest/adduser")
    public ResponseEntity<User> add(@RequestBody User user) {
        return apiService.addUser(user);
    }

    @PostMapping(value = "/rest/edituser")
    public ResponseEntity<User> edit(@RequestBody User user) {
        return apiService.editUser(user);
    }

    @GetMapping(value = "/rest/deleteuser/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        return apiService.deleteUser(id);
    }
}
