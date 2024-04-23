package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos() {
        lottos = new ArrayList();
    }

    public int generateByPrice(int price) {
        int numberOfLotto = price / 1000;
        for (int number = 1; number <= numberOfLotto; number++) {
            Lotto lotto = new Lotto();
            lotto.generate();
            lottos.add(lotto);
        }
        return lottos.size();
    }

    public Map<Integer, Integer> findAllWinningLotto(Lotto winningLotto) {
        Map<Integer, Integer> result = initializeFindWinningResult();
        for (Lotto lotto : lottos) {
            int winningCount = lotto.findWinningCount(winningLotto);
            int savedValue = result.get(winningCount) + 1;
            result.replace(winningCount, savedValue);
        }

        return result;
    }

    private Map<Integer, Integer> initializeFindWinningResult() {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(3, 0);
        result.put(4, 0);
        result.put(5, 0);
        result.put(6, 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}