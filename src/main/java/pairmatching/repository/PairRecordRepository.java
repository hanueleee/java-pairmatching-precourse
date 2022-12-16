package pairmatching.repository;

import pairmatching.domain.PairRecord;

import java.util.List;

public class PairRecordRepository {
    private List<PairRecord> pairRecords;

    public void save(PairRecord p) {

    }

    public PairRecord findByMission(String mission) {
        return null;
    }

    public List<PairRecord> findByLevel(Enum level) {
        return null;
    }

    public void deleteAll() {

    }
}
