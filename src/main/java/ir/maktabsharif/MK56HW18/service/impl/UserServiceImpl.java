package ir.maktabsharif.MK56HW18.service.impl;

import ir.maktabsharif.MK56HW18.repository.UserRepository;
import ir.maktabsharif.MK56HW18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository ticketRepository;

    @Autowired
    public UserServiceImpl(UserRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

}
