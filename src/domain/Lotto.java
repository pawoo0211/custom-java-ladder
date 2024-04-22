package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>(6);
    }

    public int generate() {
        LottoGenerator.generate(numbers);
        return numbers.size();
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
