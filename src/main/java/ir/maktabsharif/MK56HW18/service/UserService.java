package ir.maktabsharif.MK56HW18.service;

import ir.maktabsharif.MK56HW18.controller.DTO.TicketAddInfo;
import ir.maktabsharif.MK56HW18.controller.enums.Status;
import ir.maktabsharif.MK56HW18.model.Ticket;
import ir.maktabsharif.MK56HW18.model.User;

public interface UserService {
    User addUser(User user);

    Status loginUser(User user);

    User getUserByUsername(String username);

    Ticket addTicket(TicketAddInfo ticketAddInfo);
}
