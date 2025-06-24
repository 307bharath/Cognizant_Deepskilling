package MockitoExercises.ArgumentMatching;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {
    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.processData("hello");

        verify(mockApi).getData(anyString());// Verify that any string was passed
        verify(mockApi).getData("hello");// Verify that "hello" was called
        verify(mockApi, never()).getData("world");// Verify that "world" was never called
        verify(mockApi, times(1)).getData("hello");// Exactly once is equivalent to times(1)
        verify(mockApi, atMost(1)).getData("hello");// At most once is equivalent to atMost(1)
        verify(mockApi, atLeast(1)).getData("hello");// At least once is equivalent to atLeast(1)
        verify(mockApi, times(1)).getData(argThat(input -> input.startsWith("h"))); // Custom argument matcher      
    }
}
