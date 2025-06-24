package JUnit_AdvancedTesting.TestSuitis;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CalculatorTest.class, EvenCheckerTest.class})
public class AllTests {
    // This class is empty; it only holds the suite annotations.
}
