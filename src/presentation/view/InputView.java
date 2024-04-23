package presentation.view;

import application.dto.request.LottoGenerateRequest;

import java.util.Scanner;

public class InputView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입 금액을 입력해 주세요.");
        int price = scanner.nextInt();

        LottoGenerateRequest request = new LottoGenerateRequest(price);

    }
}