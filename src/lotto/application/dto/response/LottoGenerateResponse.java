package lotto.application.dto.response;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class LottoGenerateResponse {
    private List<Integer> lottoNumber;

    public LottoGenerateResponse(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoGenerateResponse from(Lotto lotto) {
        List<Integer> lottoNumber = lotto.getNumbers();
        return new LottoGenerateResponse(lottoNumber);
    }


    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
