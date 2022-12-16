package pairmatching.domain;

import pairmatching.enums.Course;
import pairmatching.enums.Level;
import pairmatching.repository.PairRecordRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class PairMatcher {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private PairRecordRepository pairRecordRepository;

    public PairMatcher(PairRecordRepository pairRecordRepository) {
        this.pairRecordRepository = pairRecordRepository;
    }

    public void run() {
        outputView.printCourseAndMisson();
        prepareMatch();

    }

    public List<String> prepareMatch() {
        List<String> inputs = inputView.readCourseAndMission();
        Course course = Course.valueOf(inputs.get(0));
        Level level = Level.valueOf(inputs.get(1));
        String mission = inputs.get(2);

        if(hasMatchRecord(mission)) {
            outputView.printRematch();
            String command = inputView.readRematch();
            if (command.equals("네")) {
                return inputs;
            }
            if (command.equals("아니오")) {
                return prepareMatch();
            }
        }
        return inputs;
    }

    public boolean hasMatchRecord(String mission) {
        PairRecord record = pairRecordRepository.findByMission(mission);
        if (record == null) {
            return false;
        }
        return true;
    }

    public void match(Course course, Level level, String mission) {

    }
}
