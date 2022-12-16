package pairmatching.domain;

import pairmatching.repository.PairRecordRepository;

public class PairInitializer {
    private PairRecordRepository pairRecordRepository;

    public PairInitializer(PairRecordRepository pairRecordRepository) {
        this.pairRecordRepository = pairRecordRepository;
    }

    public void run() {

    }
}
