package ir.maktabsharif.MK56HW18.service.impl;

import ir.maktabsharif.MK56HW18.model.User;
import ir.maktabsharif.MK56HW18.repository.UserRepository;
import ir.maktabsharif.MK56HW18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        User save = userRepository.save(user);
        return save;
    }
}
