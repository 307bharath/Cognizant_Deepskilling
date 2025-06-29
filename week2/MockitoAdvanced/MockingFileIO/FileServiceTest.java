package MockitoAdvanced.MockingFileIO;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileServiceTest {
    @Test
    public void testServiceWithMockFileIO() {
        // 1. Create mocks for FileReader and FileWriter
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        // 2. Stub FileReader's read method
        when(mockFileReader.read()).thenReturn("Mock File Content");

        // 3. Inject mocks into FileService
        FileService fileService = new FileService(mockFileReader, mockFileWriter);

        // 4. Execute processFile and verify result
        String result = fileService.processFile();
        assertEquals("Processed Mock File Content", result);

        // 5. Verify that write() was called with correct argument
        verify(mockFileWriter).write("Processed Mock File Content");
    }
}
