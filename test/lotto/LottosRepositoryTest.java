package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.infrastructure.repository.LottosRepository;
import lotto.infrastructure.repository.LottosRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("로또 Repository 테스트")
public class LottosRepositoryTest {
    private LottosRepository repository;

    @BeforeEach
    void setUp() {
        repository = new LottosRepositoryImpl();
    }


    @Test
    void saveAndFind() {
        Lottos lottos_원본 = 로또_일급_컬렉션_생성();
        repository.save(lottos_원본);
        Lottos lotto_복사본 = repository.find(lottos_원본.getId());
        System.out.println(lotto_복사본);
    }

    private Lottos 로또_일급_컬렉션_생성() {
        Lotto 테스트_로또_1 = new Lotto(Arrays.asList(1,2,3,4,5,7));
        Lotto 테스트_로또_2 = new Lotto(Arrays.asList(1,2,3,4,7,8));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(테스트_로또_1);
        lottos.add(테스트_로또_2);
        return new Lottos(lottos);
    }
}
