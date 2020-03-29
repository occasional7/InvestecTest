import java.util.Optional;

public class NumberExtractor {
    public static Optional<Long> extract(String text) {
        try {
            return Optional.of(Long.parseLong(text.replaceAll("[^#,0-9]", "")));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
