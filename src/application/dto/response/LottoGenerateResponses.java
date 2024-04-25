package application.dto.response;

import domain.lotto.Lotto;
import domain.lotto.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerateResponses {
    private int numberOfLotto;
    private List<LottoGenerateResponse> lottoGenerateResponseList;

    public LottoGenerateResponses(int numberOfLotto, List<LottoGenerateResponse> lottoGenerateResponseList) {
        this.numberOfLotto = numberOfLotto;
        this.lottoGenerateResponseList = lottoGenerateResponseList;
    }

    public static LottoGenerateResponses from(Lottos lottos) {
        List<LottoGenerateResponse> lottoGenerateResponseList = new ArrayList<>();
        for (Lotto lotto : lottos.getLottoList()) {
            lottoGenerateResponseList.add(LottoGenerateResponse.from(lotto));
        }
        return new LottoGenerateResponses(lottos.numberOfLotto(), lottoGenerateResponseList);
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    public List<LottoGenerateResponse> getLottoGenerateResponseList() {
        return lottoGenerateResponseList;
    }
}