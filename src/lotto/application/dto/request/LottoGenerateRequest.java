package lotto.application.dto.request;

public class LottoGenerateRequest {
    private int price;

    public LottoGenerateRequest(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
