import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class Main {
    public final static void main(String[] args) throws IOException {
        if (args.length == 1) {
            String text = Files.readString(Path.of(args[0]));
            Optional<Long> number = NumberExtractor.extract(text);
            if (number.isPresent()){
                String numberInString = Converter.convert(number.get());
                System.out.println(numberInString);
            } else {
                System.out.println("number invalid");
            }
        } else {
            throw new IllegalArgumentException("Provide path to file in program arguments!");
        }
    }
}
