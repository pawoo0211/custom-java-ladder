package application.service;

import application.dto.request.LottoGenerateRequest;
import application.dto.request.LottoResultRequest;
import application.dto.response.LottoGenerateResponses;
import application.dto.response.LottoResultResponse;
import domain.delimiter.CommaAndSpaceSplit;
import domain.lotto.Lotto;
import domain.lotto.Lottos;
import infrastructure.repository.LottosRepository;
import infrastructure.repository.LottosRepositoryImpl;

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
        return null;
    }
}