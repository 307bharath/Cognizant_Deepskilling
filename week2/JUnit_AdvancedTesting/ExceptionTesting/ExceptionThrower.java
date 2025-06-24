package JUnit_AdvancedTesting.ExceptionTesting;

public class ExceptionThrower {
    public void throwException() {
        throw new IllegalArgumentException("This is an exception");
    }

    public void throwArithmeticException() {
        throw new ArithmeticException("This is an arithmetic exception");
    }
}
