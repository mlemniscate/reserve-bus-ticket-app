package ir.maktabsharif.MK56HW18.controller;

import ir.maktabsharif.MK56HW18.controller.DTO.UserTicket;
import ir.maktabsharif.MK56HW18.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/ticket/user-tickets")
    @CrossOrigin
    public List<UserTicket> findTicketsByUsername(@RequestParam String username) {
        return ticketService.getAllUserTickets(username);
    }

}
