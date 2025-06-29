package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSearchByName_CustomQuery_ReturnsResults() {
        // Setup - save users
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Alice");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Bob");

        User user3 = new User();
        user3.setId(3L);
        user3.setName("Alice");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        // Test custom query
        List<User> alices = userRepository.searchByName("Alice");

        // Assert
        assertEquals(2, alices.size());
        assertTrue(alices.stream().allMatch(u -> u.getName().equals("Alice")));
    }
}
