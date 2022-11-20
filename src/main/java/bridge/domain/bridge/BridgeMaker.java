package bridge.domain.bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static bridge.support.ErrorMessage.BRIDGE_MAKER_SIZE_ERROR;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);
        return Stream.generate(bridgeNumberGenerator::generate)
                .map(BridgeUnit::from)
                .map(BridgeUnit::getCode)
                .limit(size)
                .collect(Collectors.toList());
    }

    private void validateSize(int size) {
        if (!(MINIMUM_BRIDGE_SIZE <= size && size <= MAXIMUM_BRIDGE_SIZE)) {
            throw new IllegalArgumentException(BRIDGE_MAKER_SIZE_ERROR);
        }
    }
}