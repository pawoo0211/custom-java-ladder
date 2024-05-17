package lotto.application.dto.request;

public class LottoResultRequest {
    private String id;
    private String winningNumber;

    public LottoResultRequest(String winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void addId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getWinningNumber() {
        return winningNumber;
    }
}
