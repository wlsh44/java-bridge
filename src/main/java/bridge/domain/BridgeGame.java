package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.GameStatus.FAILED;
import static bridge.domain.GameStatus.PLAYING;
import static bridge.domain.GameStatus.SUCCESS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final List<MapUnit> gameMap;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.gameMap = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus move(BridgeUnit nextUnit) {
        if (!canMove(nextUnit)) {
            gameMap.add(new MapUnit(nextUnit, false));
            return FAILED;
        }
        gameMap.add(new MapUnit(nextUnit, true));
        if (gameMap.size() == bridge.getSize()) {
            return SUCCESS;
        }
        return PLAYING;
    }

    private boolean canMove(BridgeUnit nextUnit) {
        int position = gameMap.size();
        return bridge.getUnit(position).equals(nextUnit);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public List<MapUnit> getGameMap() {
        return gameMap;
    }
}
