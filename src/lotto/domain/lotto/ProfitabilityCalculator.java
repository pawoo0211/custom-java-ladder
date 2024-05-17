package lotto.domain.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class ProfitabilityCalculator {

    public BigDecimal calculate(int price, Map<Integer, Integer> winningLottoMap) {
        BigDecimal bigDecimalPrice = BigDecimal.valueOf(price);
        BigDecimal total = sum(winningLottoMap);
        BigDecimal result = total.divide(bigDecimalPrice, 2, BigDecimal.ROUND_DOWN);


        return result;
    }

    private BigDecimal sum(Map<Integer, Integer> winningLottoMap) {
        int sum = 0;
        Integer countThree = winningLottoMap.get(3);
        Integer countFour = winningLottoMap.get(4);
        Integer countFive = winningLottoMap.get(5);
        Integer countSix = winningLottoMap.get(6);

        sum = sum + (countThree * 5000);
        sum = sum + (countFour * 50000);
        sum = sum + (countFive * 1500000);
        sum = sum + (countSix * 2000000000);

        return new BigDecimal(sum);
    }
}
