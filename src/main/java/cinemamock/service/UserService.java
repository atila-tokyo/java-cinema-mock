package cinemamock.service;

import cinemamock.model.entities.User;

public interface UserService {
    User login(final String email, final String password);

    User findUserByEmail(final String email);
}