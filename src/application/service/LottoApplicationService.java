package application.service;

import application.dto.request.LottoGenerateRequest;
import application.dto.response.LottoGenerateResponses;
import domain.lotto.Lottos;


public class LottoApplicationService {

    public LottoGenerateResponses generateLotto(LottoGenerateRequest request) {
        int price = request.getPrice();

        Lottos lottos = new Lottos();
        lottos.generateByPrice(price);

        return LottoGenerateResponses.from(lottos);
    }
}
