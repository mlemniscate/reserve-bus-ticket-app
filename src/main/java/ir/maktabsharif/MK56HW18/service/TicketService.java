package ir.maktabsharif.MK56HW18.service;

import ir.maktabsharif.MK56HW18.controller.DTO.UserTicket;

import java.util.List;

public interface TicketService {
    List<UserTicket> getAllUserTickets(String username);
}
