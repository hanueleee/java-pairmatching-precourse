package pairmatching.domain;

import pairmatching.repository.PairRecordRepository;

public class PairFinder {
    private PairRecordRepository pairRecordRepository;

    public PairFinder(PairRecordRepository pairRecordRepository) {
        this.pairRecordRepository = pairRecordRepository;
    }

    public void run() {

    }
}
