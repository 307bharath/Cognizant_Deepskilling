package JUnit_AdvancedTesting.ExceptionTesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    void testThrowException() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertThrows(IllegalArgumentException.class, thrower::throwException);
    }
    @Test
    void testThrowArithmeticException() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertThrows(ArithmeticException.class, thrower::throwArithmeticException);
    }
}
