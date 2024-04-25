package infrastructure.repository;

import domain.lotto.Lottos;

import java.util.HashMap;
import java.util.Map;

public class LottosRepositoryImpl implements LottosRepository {
    private final Map<String, Lottos> lottosMap = new HashMap<>();

    @Override
    public boolean save(Lottos lottos) {
        lottosMap.put(lottos.getId(), lottos);
        return true;
    }

    @Override
    public Lottos find(String id) {
        return lottosMap.get(id);
    }
}
