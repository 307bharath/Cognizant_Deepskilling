package MockitoExercises.VerifyingInteractions;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import MockitoExercises.MockingAndStubbing.ExternalApi;
import MockitoExercises.MockingAndStubbing.MyService;

public class MyServiceTest {
    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }
}