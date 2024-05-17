package lotto.presentation.view;

import lotto.application.dto.response.LottoGenerateResponse;
import lotto.application.dto.response.LottoGenerateResponses;

import java.util.List;

public class ResultView {

    public void printGeneratedLotto(LottoGenerateResponses responses) {
        int numberOfLotto = responses.getNumberOfLotto();
        List<LottoGenerateResponse> lottoGenerateResponses = responses.getLottoGenerateResponseList();

        System.out.println(numberOfLotto + "개를 구매했습니다.");

        for (LottoGenerateResponse lottoGenerateResponse : lottoGenerateResponses) {
            System.out.println(lottoGenerateResponse.getLottoNumber());
        }
    }
}
