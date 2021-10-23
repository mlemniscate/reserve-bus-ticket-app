package ir.maktabsharif.MK56HW18.controller;

import ir.maktabsharif.MK56HW18.model.User;
import ir.maktabsharif.MK56HW18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public User registerUser(@RequestBody User user) {
        return userService.addUser(user);
    }

}
