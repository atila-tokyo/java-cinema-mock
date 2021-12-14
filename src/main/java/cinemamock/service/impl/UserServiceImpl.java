package cinemamock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinemamock.model.entities.User;
import cinemamock.model.repository.UserRepository;
import cinemamock.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(final String email, final String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}