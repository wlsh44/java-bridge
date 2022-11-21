package bridge.domain.game;

public enum GameStatus {
    FAILED("실패"),
    SUCCESS("성공");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
