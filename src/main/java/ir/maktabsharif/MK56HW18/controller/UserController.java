package ir.maktabsharif.MK56HW18.controller;

import ir.maktabsharif.MK56HW18.controller.enums.Status;
import ir.maktabsharif.MK56HW18.model.User;
import ir.maktabsharif.MK56HW18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public User registerUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/user/login")
    @CrossOrigin
    public Status loginUser(@RequestBody User user) {
        Status status = userService.loginUser(user);
//        if(status.equals(Status.SUCCESS)) {
//            HttpSession session = request.getSession();
//            session.setAttribute("username", user.getUsername());
//        }
        return status;
    }

}
