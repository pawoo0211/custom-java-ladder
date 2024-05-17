package lotto.infrastructure.repository;

import lotto.domain.lotto.Lottos;

public interface LottosRepository {
    boolean save(Lottos lottos);

    Lottos find(String id);
}
