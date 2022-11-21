package bridge.controller;

import bridge.domain.Command;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.domain.Command.validateGameCommand;
import static bridge.domain.bridge.Bridge.validateBridgeSize;
import static bridge.domain.Move.validateMoving;

public class ReadController {

    private final InputView inputView;

    public ReadController() {
        this.inputView = new InputView();
    }

    public int readBridgeSize() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            validateBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            String moving = inputView.readMoving();
            validateMoving(moving);
            return moving;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readMoving();
        }
    }

    public Command readGameCommand() {
        try {
            String command = inputView.readGameCommand();
            validateGameCommand(command);
            return Command.from(command);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readGameCommand();
        }
    }
}
