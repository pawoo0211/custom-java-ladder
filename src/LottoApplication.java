import application.dto.request.LottoGenerateRequest;
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
        LottoGenerateRequest request = controller.inputPrice();

        // 로또 생성
        LottoGenerateResponses responses = controller.generateLotto(request);

        // 생성된 로또 출력
        controller.printGeneratedLotto(responses);


    }
}