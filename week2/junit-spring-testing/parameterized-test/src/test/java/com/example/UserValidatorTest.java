package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"John", "Alice", "Bob", "Charlie"})
    void validNames_ShouldReturnTrue(String name) {
        assertTrue(UserValidator.isValidName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "A", "Jo", "  ", "\n", "\t"})
    void invalidNames_ShouldReturnFalse(String name) {
        assertFalse(UserValidator.isValidName(name));
    }
}
