package MockitoAdvanced.MokingRepoDatabase;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    @Test
    public void testServiceWithMockRepository() {
        // 1. Create mock Repository
        Repository mockRepository = mock(Repository.class);

        // 2. Stub getData() method
        when(mockRepository.getData()).thenReturn("Mock Data");

        // 3. Inject mock into Service and test logic
        Service service = new Service(mockRepository);
        String result = service.processData();

        // 4. Verify result
        assertEquals("Processed Mock Data", result);
    }
}