package app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {


    @GetMapping("/admin/userslist")
    public String webPage (Model theModel1) {
        return "adminUsersListRest";
    }

    @GetMapping("/user")
    public String userPage() {
        return "userPage";
    }

}
