package bridge.domain.game;

import bridge.domain.bridge.BridgeUnit;

public class GameProgress {
    private final BridgeUnit bridgeUnit;
    private final boolean success;

    public GameProgress(BridgeUnit bridgeUnit, boolean success) {
        this.bridgeUnit = bridgeUnit;
        this.success = success;
    }

    public BridgeUnit getBridgeUnit() {
        return bridgeUnit;
    }

    public boolean isSuccess() {
        return success;
    }
}