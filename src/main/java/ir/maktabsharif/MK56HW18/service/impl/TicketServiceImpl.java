package ir.maktabsharif.MK56HW18.service.impl;

import ir.maktabsharif.MK56HW18.controller.DTO.UserTicket;
import ir.maktabsharif.MK56HW18.model.Ticket;
import ir.maktabsharif.MK56HW18.repository.TicketRepository;
import ir.maktabsharif.MK56HW18.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    @Override
    public List<UserTicket> getAllUserTickets(String username) {
        List<Ticket> tickets = ticketRepository.findAllByUser_Username(username);
        List<UserTicket> userTickets = new ArrayList<>();
        tickets.forEach(item -> {
            userTickets.add(new UserTicket(
                    item.getId(),
                    item.getOwnerName(),
                    item.getGender(),
                    item.getTravel().getInitialPoint(),
                    item.getTravel().getDestination(),
                    item.getTravel().getTravelDate(),
                    item.getTravel().getTravelTime(),
                    item.getTravel().getId()
            ));
        });
        return userTickets;
    }
}
