package domain.lotto;

import java.util.*;

public class Lottos {
    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Lottos() {
        lottoList = new ArrayList();
    }

    public int generateByPrice(int price) {
        int numberOfLotto = price / 1000;
        for (int number = 1; number <= numberOfLotto; number++) {
            Lotto lotto = new Lotto();
            lotto.generate();
            lottoList.add(lotto);
        }
        return lottoList.size();
    }

    public Map<Integer, Integer> findAllWinningLotto(Lotto winningLotto) {
        Map<Integer, Integer> result = initializeFindWinningResult();
        for (Lotto lotto : lottoList) {
            int winningCount = lotto.findWinningCount(winningLotto);
            int savedValue = result.get(winningCount) + 1;
            result.replace(winningCount, savedValue);
        }

        return Collections.unmodifiableMap(result);
    }

    private Map<Integer, Integer> initializeFindWinningResult() {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(3, 0);
        result.put(4, 0);
        result.put(5, 0);
        result.put(6, 0);
        return result;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public int numberOfLotto() {
        return lottoList.size();
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottoList +
                '}';
    }
}