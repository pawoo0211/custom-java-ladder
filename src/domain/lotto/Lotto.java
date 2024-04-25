package domain.lotto;

import domain.delimiter.SplitStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String stringNumbers, SplitStrategy splitStrategy) {
        String[] numbers = splitStrategy.split(stringNumbers);
        this.numbers = Arrays.stream(numbers)
                .map(number -> Integer.valueOf(number))
                .collect(Collectors.toList());
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto() {
        numbers = new ArrayList<>(6);
    }

    public int generate() {
        LottoGenerator.generate(numbers);
        return numbers.size();
    }

    public int findWinningCount(Lotto winningLotto) {
        int count = 0;
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index).equals(winningLotto.numbers.get(index))) {
                count++;
            }
        }

        return count;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
