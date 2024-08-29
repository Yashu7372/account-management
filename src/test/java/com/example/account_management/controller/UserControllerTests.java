package com.example.account_management.controller;

import com.example.account_management.model.User;
import com.example.account_management.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTests {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setId(1L);
        when(userService.createUser(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.createUser(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1L);
        when(userService.getUserById(1L)).thenReturn(user);

        ResponseEntity<User> response = userController.getUserById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetAllUsers() {
        when(userService.getAllUsers()).thenReturn(Collections.emptyList());

        ResponseEntity<Object> response = userController.getAllUsers();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        user.setId(1L);
        when(userService.updateUser(anyLong(), any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.updateUser(1L, user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userService).deleteUser(anyLong());

        ResponseEntity<Void> response = userController.deleteUser(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testChangePassword() {
        User user = new User();
        user.setId(1L);
        when(userService.changePassword(anyLong(), anyString())).thenReturn(user);

        ResponseEntity<User> response = userController.changePassword(1L, "newPassword");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}
