package lotto.domain.delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommaAndSpaceSplit implements SplitStrategy {
    private static final Pattern PATTERN = Pattern.compile(",\\s*");

    @Override
    public String[] split(String input) {
        String[] tokens = {};
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            tokens = matcher.group(2).split(customDelimiter);
            return tokens;
        }
        return tokens;
    }
}
