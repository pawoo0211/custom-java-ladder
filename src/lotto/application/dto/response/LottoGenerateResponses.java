package lotto.application.dto.response;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerateResponses {
    private String id;
    private int numberOfLotto;
    private List<LottoGenerateResponse> lottoGenerateResponseList;

    public LottoGenerateResponses(String id, int numberOfLotto, List<LottoGenerateResponse> lottoGenerateResponseList) {
        this.id = id;
        this.numberOfLotto = numberOfLotto;
        this.lottoGenerateResponseList = lottoGenerateResponseList;
    }

    public static LottoGenerateResponses from(Lottos lottos) {
        List<LottoGenerateResponse> lottoGenerateResponseList = new ArrayList<>();
        for (Lotto lotto : lottos.getLottoList()) {
            lottoGenerateResponseList.add(LottoGenerateResponse.from(lotto));
        }
        return new LottoGenerateResponses(lottos.getId(), lottos.numberOfLotto(), lottoGenerateResponseList);
    }

    public String getId() {
        return id;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    public List<LottoGenerateResponse> getLottoGenerateResponseList() {
        return lottoGenerateResponseList;
    }
}
