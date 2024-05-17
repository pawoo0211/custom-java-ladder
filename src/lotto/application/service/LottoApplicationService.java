package lotto.application.service;

import lotto.application.dto.request.LottoGenerateRequest;
import lotto.application.dto.request.LottoResultRequest;
import lotto.application.dto.response.LottoGenerateResponses;
import lotto.application.dto.response.LottoResultResponse;
import lotto.domain.delimiter.CommaAndSpaceSplit;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.ProfitabilityCalculator;
import lotto.infrastructure.repository.LottosRepository;
import lotto.infrastructure.repository.LottosRepositoryImpl;

import java.math.BigDecimal;
import java.util.Map;


public class LottoApplicationService {
    private final LottosRepository repository;

    public LottoApplicationService() {
        this.repository = new LottosRepositoryImpl();
    }

    public LottoGenerateResponses generateLotto(LottoGenerateRequest request) {
        int price = request.getPrice();

        Lottos lottos = new Lottos();
        lottos.generateByPrice(price);
        repository.save(lottos);

        return LottoGenerateResponses.from(lottos);
    }

    public LottoResultResponse obtainResult(LottoResultRequest resultRequest) {
        Lottos lottos = repository.find(resultRequest.getId());
        String winningNumber = resultRequest.getWinningNumber();
        Lotto winningLotto = new Lotto(winningNumber, new CommaAndSpaceSplit());
        Map<Integer, Integer> result = lottos.findAllWinningLotto(winningLotto);
        BigDecimal profitability = new ProfitabilityCalculator().calculate(lottos.getLottoList().size() * 1000, result);
        System.out.println("수익률 : " + profitability);

        return null;
    }
}
