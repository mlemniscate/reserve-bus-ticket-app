package ir.maktabsharif.MK56HW18.service.impl;

import ir.maktabsharif.MK56HW18.controller.DTO.TicketAddInfo;
import ir.maktabsharif.MK56HW18.controller.enums.Status;
import ir.maktabsharif.MK56HW18.model.Ticket;
import ir.maktabsharif.MK56HW18.model.Travel;
import ir.maktabsharif.MK56HW18.model.User;
import ir.maktabsharif.MK56HW18.repository.TravelRepository;
import ir.maktabsharif.MK56HW18.repository.UserRepository;
import ir.maktabsharif.MK56HW18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private TravelRepository travelRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TravelRepository travelRepository) {
        this.userRepository = userRepository;
        this.travelRepository = travelRepository;
    }

    @Override
    public User addUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public Status loginUser(User user) {
        User byUsername = userRepository.findByUsername(user.getUsername());
        if(Objects.isNull(byUsername)) return Status.FAILURE;
        else if(!byUsername.getPassword().equals(user.getPassword())) return Status.FAILURE;
        else return Status.SUCCESS;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addTicket(TicketAddInfo ticketAddInfo) {
        User user = userRepository.findByUsername(ticketAddInfo.getUsername());
        Travel travel = travelRepository.getById(ticketAddInfo.getTravelId());
        user.getTickets().add(
                new Ticket(
                        ticketAddInfo.getOwnerName(),
                        ticketAddInfo.getGender(),
                        travel
                )
        );
        userRepository.save(user);
    }
}
