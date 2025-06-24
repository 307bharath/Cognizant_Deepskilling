package MockitoExercises.VoidMethodWithException;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import MockitoExercises.HandlingVoidMethods.ExternalApi;

public class MyServiceTest {
    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the void method to throw an exception
        doThrow(new RuntimeException("Error!")).when(mockApi).sendNotification(anyString());

        // Verify the exception is thrown when the method is called
        assertThrows(RuntimeException.class, () -> mockApi.sendNotification("Hello"));

        // Verify the interaction
        verify(mockApi).sendNotification("Hello");
    }
}