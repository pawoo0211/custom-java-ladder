package lotto.presentation.view;

import lotto.application.dto.request.LottoGenerateRequest;
import lotto.application.dto.request.LottoResultRequest;

import java.util.Scanner;

public class InputView {

    public LottoGenerateRequest inputPrice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입 금액을 입력해 주세요.");
        int price = scanner.nextInt();

        LottoGenerateRequest request = new LottoGenerateRequest(price);
        return request;
    }

    public LottoResultRequest inputWinningNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = scanner.nextLine();

        LottoResultRequest request = new LottoResultRequest(winningNumber);
        return request;
    }
}
