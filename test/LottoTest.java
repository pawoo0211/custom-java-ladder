
import domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@DisplayName("로또 도메인 테스트")
public class LottoTest {

    @Test
    void generate() {
        Lotto lotto = new Lotto();
        Assertions.assertThat(lotto.generate()).isEqualTo(6);
        System.out.println(lotto);
    }

    @Test
    void generateLottosByPrice() {
        Lottos lottos = new Lottos();
        int 생성된_로또_개수 = lottos.generateByPrice(14000);
        Assertions.assertThat(생성된_로또_개수).isEqualTo(14);
        System.out.println(lottos);
    }

    class Lottos {
        private List<Lotto> lottos;

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

        @Override
        public String toString() {
            return "Lottos{" +
                    "lottos=" + lottos +
                    '}';
        }
    }
}