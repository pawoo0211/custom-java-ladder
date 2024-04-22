
import domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTest {
    @Test
    void generate() {
        Lotto lotto = new Lotto();
        Assertions.assertThat(lotto.generate()).isEqualTo(6);
        System.out.println(lotto);
    }
}