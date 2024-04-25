import application.dto.request.LottoGenerateRequest;
import application.dto.request.LottoResultRequest;
import application.dto.response.LottoGenerateResponses;
import application.service.LottoApplicationService;
import presentation.controller.LottoApplicationController;
import presentation.view.InputView;
import presentation.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoApplicationController controller = new LottoApplicationController(
                new InputView(),
                new ResultView(),
                new LottoApplicationService()
        );

        // 구입 금액 입력
        LottoGenerateRequest generateRequest = controller.inputPrice();

        // 로또 생성
        LottoGenerateResponses responses = controller.generateLotto(generateRequest);

        // 생성된 로또 출력
        controller.printGeneratedLotto(responses);

        // 당첨 번호 입력
        LottoResultRequest resultRequest = controller.inputWinningNumber(responses.getId());

        // 당첨 통계 출력
        controller.printResult(resultRequest);
    }
}