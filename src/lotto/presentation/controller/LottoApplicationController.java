package lotto.presentation.controller;

import lotto.application.dto.request.LottoGenerateRequest;
import lotto.application.dto.request.LottoResultRequest;
import lotto.application.dto.response.LottoGenerateResponses;
import lotto.application.dto.response.LottoResultResponse;
import lotto.application.service.LottoApplicationService;
import lotto.presentation.view.InputView;
import lotto.presentation.view.ResultView;

public class LottoApplicationController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoApplicationService service;

    public LottoApplicationController(InputView inputView, ResultView resultView, LottoApplicationService service) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.service = service;
    }

    public LottoGenerateRequest inputPrice() {
        LottoGenerateRequest request = inputView.inputPrice();
        return request;
    }

    public LottoGenerateResponses generateLotto(LottoGenerateRequest request) {
        LottoGenerateResponses response = service.generateLotto(request);
        return response;
    }

    public void printGeneratedLotto(LottoGenerateResponses responses) {
        resultView.printGeneratedLotto(responses);
    }

    public LottoResultRequest inputWinningNumber(String id) {
        LottoResultRequest request = inputView.inputWinningNumber();
        request.addId(id);
        return request;
    }

    public LottoResultResponse printResult(LottoResultRequest resultRequest) {
        LottoResultResponse resultResponse = service.obtainResult(resultRequest);
        return resultResponse;
    }
}
