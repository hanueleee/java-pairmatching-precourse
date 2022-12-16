package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String READ_COURSE_AND_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";
    private static final InputValidator inputValidator = new InputValidator();
    public String readOption() {
        String command = Console.readLine();
        inputValidator.validateOptionCommand(command);
        return command;
    }

    public List<String> readCourseAndMission() {
        String command = Console.readLine();
        inputValidator.validateCourseAndMissionCommand(command);
        return Arrays.asList(command.split(", "));
    }

    public String readRematch() {
        String command = Console.readLine();
        inputValidator.validateRematchCommand(command);
        return command;
    }
}
