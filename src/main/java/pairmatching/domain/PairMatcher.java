package pairmatching.domain;

import pairmatching.enums.Course;
import pairmatching.enums.Level;
import pairmatching.repository.PairRecordRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairMatcher {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private PairRecordRepository pairRecordRepository;

    public PairMatcher(PairRecordRepository pairRecordRepository) {
        this.pairRecordRepository = pairRecordRepository;
    }

    public void run() {
        outputView.printCourseAndMisson();
        List<String> inputs = prepareMatch();
        match(inputs);
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

    public void match(List<String> inputs) {
        Course course = Course.valueOf(inputs.get(0));
        Level level = Level.valueOf(inputs.get(1));
        String mission = inputs.get(2);

        List<String> crewNames = new ArrayList<>();
        try {
            crewNames = getCrewNames(course.getLabel());
        } catch (Exception e) {
            System.out.println("[ERROR] 파일에 문제가 있습니다.");
        }
        
        PairGenerator pairGenerator = new PairGenerator(crewNames);
        List<Pair> createdPair = pairGenerator.createPair();

    }

    public List<String> getCrewNames(String course) throws Exception {
        ClassLoader classLoader = PairMatcher.class.getClassLoader();
        File file = new File("tmp", "tmp");
        if (course.equals("백엔드")) {
            file = new File(classLoader.getResource("backend-crew.md").getFile());
        }
        if (course.equals("프론트엔드")) {
            file = new File(classLoader.getResource("frontend-crew.md").getFile());
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> crewNames = reader.lines().collect(Collectors.toList());
        reader.close();
        return crewNames;
    }
}
