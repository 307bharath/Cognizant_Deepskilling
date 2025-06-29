package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.util.Optional;

public class UserServiceTest {

    @Test
    void testGetUserById_UserNotFound_ThrowsException() {
        // Mock the repository
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(999L)).thenReturn(Optional.empty());

        // Inject the mock into the service
        UserService userService = new UserService(mockRepo); // if not using setter, make field public/package-private for test

        // Assert exception is thrown
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.getUserById(999L);
        });

        assertEquals("User not found", exception.getMessage());
    }
}
