package ir.maktabsharif.MK56HW18.controller;

import ir.maktabsharif.MK56HW18.model.Ticket;
import ir.maktabsharif.MK56HW18.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/ticket/buy")
    public void registerTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
    }

}
