package infrastructure.repository;

import domain.lotto.Lottos;

public interface LottosRepository {
    boolean save(Lottos lottos);

    Lottos find(String id);
}