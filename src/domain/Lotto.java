package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

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

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
