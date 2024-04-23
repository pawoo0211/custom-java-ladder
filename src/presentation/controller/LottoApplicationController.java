package presentation.controller;

import application.dto.request.LottoGenerateRequest;
import application.dto.response.LottoGenerateResponse;
import application.service.LottoApplicationService;

public class LottoApplicationController {
    private final LottoApplicationService service;

    public LottoApplicationController(LottoApplicationService service) {
        this.service = service;
    }

    public LottoGenerateResponse generateLotto(LottoGenerateRequest request) {
        LottoGenerateResponse response = service.generateLotto(request);
        return response;
    }
}