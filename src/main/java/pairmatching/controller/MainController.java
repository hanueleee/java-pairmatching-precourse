package pairmatching.controller;

import pairmatching.domain.PairFinder;
import pairmatching.domain.PairInitializer;
import pairmatching.domain.PairMatcher;
import pairmatching.repository.PairRecordRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PairMatcher pairMatcher = new PairMatcher();
    private final PairFinder pairFinder = new PairFinder();
    private final PairInitializer pairInitializer = new PairInitializer();

    public void programRun() {
        String option = "";

        while (option != "Q") {
            outputView.printOption();
            option = inputView.readOption();
            if (option == "1") {
                pairMatcher.run();
            }
            if (option == "2") {
                pairFinder.run();
            }
            if (option == "3") {
                pairInitializer.run();
            }
        }

    }
}
