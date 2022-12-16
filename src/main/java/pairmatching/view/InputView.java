package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final InputValidator inputValidator = new InputValidator();

    public String readOption() {
        String command = Console.readLine();
        inputValidator.validateOptionCommand(command);
        return command;
    }

    public List<String> readCourseAndMission() {
        return null;
    }

    public String readRematch() {
        return null;
    }
}
