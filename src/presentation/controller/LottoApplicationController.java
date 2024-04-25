package presentation.controller;

import application.dto.request.LottoGenerateRequest;
import application.dto.response.LottoGenerateResponse;
import application.dto.response.LottoGenerateResponses;
import application.service.LottoApplicationService;
import presentation.view.InputView;
import presentation.view.ResultView;

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
}