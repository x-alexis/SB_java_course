import org.example.Main;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.File;

import static org.example.Main.getHumanReadableSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test of methods")
public class MainTests {
    @Test
    @DisplayName("Calculate file size")
    public void getFileSize() {
        final Long expectedSize = 2376L;
        File file = new File("Data/Readme.txt");
        Long fileSize = Main.getFolderSize(file);
        assertEquals(expectedSize, fileSize);
    }
    @Test
    @DisplayName("Calculate folder size")
    public void getFolderSize() {
        final Long expectedSize = 58088L;
        File file = new File("Data");
        Long fileSize = Main.getFolderSize(file);
        assertEquals(expectedSize, fileSize);
    }
    @Test
    @DisplayName("Result to human readable format")
    public void getNormalName() {
        String result1 = getHumanReadableSize(1200);
        final String expectedResult1 = "1.17 kb";
        String result2 = getHumanReadableSize(1250200);
        final String expectedResult2 = "1.19 Mb";
        assertEquals(expectedResult1, result1);
        assertEquals(expectedResult2, result2);
    }

}
