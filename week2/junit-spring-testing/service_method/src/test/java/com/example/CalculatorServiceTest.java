package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    @Test
    void testAdd() {
        CalculatorService service = new CalculatorService();
        int result = service.add(3, 5);
        assertEquals(8, result);
    }
}
