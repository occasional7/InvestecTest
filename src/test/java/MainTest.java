import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MainTest {
    @Test
    public void testValidNumber() throws IOException {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        File file = File.createTempFile("temp", null);
        Files.writeString(Paths.get(file.getAbsolutePath()), "We processed 9121 records.");
        Main.main(new String[]{Paths.get(file.getAbsolutePath()).toString()});
        file.deleteOnExit();

        verify(out).println(startsWith("nine thousand, one hundred and twenty-one"));
    }

    @Test
    public void testInvalidNumber() throws IOException {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        File file = File.createTempFile("temp", null);
        Files.writeString(Paths.get(file.getAbsolutePath()), "I received 23 456,9 KGs.");
        Main.main(new String[]{Paths.get(file.getAbsolutePath()).toString()});
        file.deleteOnExit();

        verify(out).println(startsWith("number invalid"));
    }

    @Test
    public void testNoArguments()  {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.main(new String[]{}));
    }
}