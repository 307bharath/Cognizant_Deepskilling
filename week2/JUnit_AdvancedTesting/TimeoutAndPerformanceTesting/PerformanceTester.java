package JUnit_AdvancedTesting.TimeoutAndPerformanceTesting;

public class PerformanceTester {
    public void performTask() {
        try {
            Thread.sleep(100); // 100 milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}