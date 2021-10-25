package ir.maktabsharif.MK56HW18.service.impl;

import ir.maktabsharif.MK56HW18.repository.TicketRepository;
import ir.maktabsharif.MK56HW18.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


}
