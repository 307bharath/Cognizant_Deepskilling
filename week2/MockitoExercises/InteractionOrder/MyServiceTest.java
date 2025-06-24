package MockitoExercises.InteractionOrder;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class MyServiceTest {
    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Call methods in a specific order
        mockApi.connect();
        mockApi.getData();
        mockApi.disconnect();

        // Verify the interaction order
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).connect();
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).disconnect();
    }
}