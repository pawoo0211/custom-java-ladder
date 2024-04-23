
import domain.lotto.Lotto;
import domain.lotto.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Test
    void findAllWinningLotto() {
        Lottos 로또_일급_컬렉션 = 로또_일급_컬렉션_생성();
        Lotto 당첨_로또 = 당첨_로또_생성();
        Map<Integer, Integer> result = 로또_일급_컬렉션.findAllWinningLotto(당첨_로또);
        Assertions.assertThat(result.get(6)).isEqualTo(0);
        Assertions.assertThat(result.get(5)).isEqualTo(1);
        Assertions.assertThat(result.get(4)).isEqualTo(1);
    }

    private Lottos 로또_일급_컬렉션_생성() {
        Lotto 테스트_로또_1 = new Lotto(Arrays.asList(1,2,3,4,5,7));
        Lotto 테스트_로또_2 = new Lotto(Arrays.asList(1,2,3,4,7,8));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(테스트_로또_1);
        lottos.add(테스트_로또_2);
        return new Lottos(lottos);
    }

    private Lotto 당첨_로또_생성() {
        String 당첨_번호 = "1, 2, 3, 4, 5, 6";
        List<Integer> winningNumbers = Arrays.stream(당첨_번호.split("[,\\s]+"))
                .map(winningNumber -> Integer.valueOf(winningNumber))
                .collect(Collectors.toList());

        return new Lotto(winningNumbers);
    }
}