package ir.maktabsharif.MK56HW18.controller;

import ir.maktabsharif.MK56HW18.controller.DTO.TicketAddInfo;
import ir.maktabsharif.MK56HW18.controller.DTO.UserWithoutPassword;
import ir.maktabsharif.MK56HW18.controller.enums.Status;
import ir.maktabsharif.MK56HW18.model.Ticket;
import ir.maktabsharif.MK56HW18.model.User;
import ir.maktabsharif.MK56HW18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user/login")
    @CrossOrigin
    public Status loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    @GetMapping("user/user")
    @CrossOrigin
    public UserWithoutPassword findUserByUsername(@RequestParam String username) {
        User userByUsername = userService.getUserByUsername(username);
        return new UserWithoutPassword(
                userByUsername.getUsername(),
                userByUsername.getFirstName(),
                userByUsername.getLastName(),
                userByUsername.getEmail()
        );
    }

    @PostMapping("/user/buy-ticket")
    @CrossOrigin
    public Long registerTicket(@RequestBody TicketAddInfo ticketَAdd) {
        Ticket ticket = userService.addTicket(ticketَAdd);
        return ticket.getId();
    }

}
