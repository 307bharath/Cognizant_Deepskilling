package JUnit_SpringTesting.ServiceMethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CalculatorServiceTest {
    @Test
    void tesAdd(){
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.add(2, 3);
        assertEquals(5, result, "2 + 3 should equal 5");
    }
}
