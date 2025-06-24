package MockitoExercises.MultipleReturns;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import MockitoExercises.MockingAndStubbing.ExternalApi;
import MockitoExercises.MockingAndStubbing.MyService;

public class MyServiceTest {
    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the method to return different values on consecutive calls
        when(mockApi.getData()).thenReturn("First", "Second", "Third", "Fourth");

        MyService service = new MyService(mockApi);

        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
        assertEquals("Third", service.fetchData());
        assertEquals("Fourth", service.fetchData());
        assertEquals("Fourth", service.fetchData()); // Last call should return the last stubbed
    }
}