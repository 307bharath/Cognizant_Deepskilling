package JUnit_AdvancedTesting.TimeoutAndPerformanceTesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    @Test
    void testPerformTaskCompletesWithinTime() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeout(
            java.time.Duration.ofMillis(200), // 200 ms timeout
            tester::performTask
        );
    }
}
