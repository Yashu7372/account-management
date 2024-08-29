package com.example.account_management.service;

import com.example.account_management.model.User;
import com.example.account_management.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTests {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setPassword("password");
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);
        assertNotNull(createdUser);
        assertEquals("encodedPassword", createdUser.getPassword());
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());

        assertTrue(userService.getAllUsers().isEmpty());
    }

    @Test
    void testGetUserById() {
        User user = new User();
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        User foundUser = userService.getUserById(1L);
        assertNotNull(foundUser);
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        when(userRepository.existsById(anyLong())).thenReturn(true);
        when(userRepository.save(any(User.class))).thenReturn(user);

        User updatedUser = userService.updateUser(1L, user);
        assertNotNull(updatedUser);
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(anyLong());

        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    void testChangePassword() {
        User user = new User();
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User updatedUser = userService.changePassword(1L, "newPassword");
        assertNotNull(updatedUser);
        assertEquals("encodedPassword", updatedUser.getPassword());
    }
}
