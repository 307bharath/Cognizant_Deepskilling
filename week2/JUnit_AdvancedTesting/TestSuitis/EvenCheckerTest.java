package JUnit_AdvancedTesting.TestSuitis;
import org.junit.jupiter.api.Test;

import JUnit_AdvancedTesting.ParamaterizedTest.EvenChecker;

import static org.junit.jupiter.api.Assertions.*;


public class EvenCheckerTest {
    @Test
    void testIsEven() {
        assertTrue(new EvenChecker().isEven(4));
    }
}