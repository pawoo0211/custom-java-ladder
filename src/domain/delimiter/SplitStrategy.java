package domain.delimiter;

public interface SplitStrategy {
    String[] split(String input);
}