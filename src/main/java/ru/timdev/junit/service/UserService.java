package ru.timdev.junit.service;

import ru.timdev.junit.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public List<User> getAll() {
        return users;
    }

    public boolean add(User user) {
        return users.add(user);
    }

    public Optional<User> login(String username, String password) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username)
                        && user.getPassword().equals(password))
                .findFirst();
    }
}
