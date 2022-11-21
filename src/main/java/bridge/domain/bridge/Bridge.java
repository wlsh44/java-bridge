package bridge.domain.bridge;

import java.util.List;

import static bridge.support.ErrorMessage.BRIDGE_MAKER_SIZE_ERROR;

public class Bridge {

    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getBridgeBlock(int position) {
        return bridge.get(position);
    }

    public int getSize() {
        return bridge.size();
    }

    public static void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < MINIMUM_BRIDGE_SIZE || MAXIMUM_BRIDGE_SIZE < bridgeSize) {
            throw new IllegalArgumentException(BRIDGE_MAKER_SIZE_ERROR);
        }
    }
}
