package MockitoExercises.HandlingVoidMethods;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the void method (doNothing is default, but shown for clarity)
        doNothing().when(mockApi).sendNotification(anyString());

        // Call the method under test
        MyService service = new MyService(mockApi);
        service.notifyUser("Hello!");

        // Verify the interaction
        verify(mockApi).sendNotification(eq("Hello!"));
    }
}
