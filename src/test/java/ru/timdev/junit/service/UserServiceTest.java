package ru.timdev.junit.service;

import org.junit.jupiter.api.*;
import ru.timdev.junit.dto.User;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class UserServiceTest {

    private UserService userService;

    @BeforeAll
    static void init() {
        System.out.println("Before All:");
    }

    @BeforeEach
    void prepare() {
        userService = new UserService();
        System.out.println("Before each: " + this);
    }

    @Test
    void usersEmptyIfNoUsersAdded() {
        System.out.println("Test1: " + this);
        var users = userService.getAll();
        Assertions.assertTrue(users.isEmpty(), () -> "User list should be empty.");
    }

    @Test
    void usersSizeIfUsersAdded() {
        System.out.println("Test2: " + this);
        userService.add(new User());
        userService.add(new User());
        var users = userService.getAll();
        Assertions.assertEquals(2, users.size());
    }

    @AfterEach
    void deleteDataFromDataBase() {
        System.out.println("After each: " + this);
        System.out.println();
    }

    @AfterAll
    static void closeConnectionPool() {
        System.out.println("After All:");
    }
}
