package cinemamock.service;

import cinemamock.model.entities.User;

public interface LoginService {
    User login(final String email, final String password);
}