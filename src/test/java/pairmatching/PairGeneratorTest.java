package pairmatching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Pair;
import pairmatching.domain.PairGenerator;
import pairmatching.domain.PairMatcher;
import pairmatching.enums.Course;
import pairmatching.repository.PairRecordRepository;

import java.util.ArrayList;
import java.util.List;

public class PairGeneratorTest {
    public PairRecordRepository pairRecordRepository = new PairRecordRepository();
    public PairMatcher pairMatcher = new PairMatcher(pairRecordRepository);

    @Test
    void 페어_제작() {
        List<String> crewNames = new ArrayList<>();
        try {
            crewNames = pairMatcher.getCrewNames(Course.BACKEND.getLabel());
        } catch (Exception e) {
            System.out.println("파일이 없습니다.");
        }

        PairGenerator pairGenerator = new PairGenerator(crewNames);
        List<Pair> pair = pairGenerator.createPair();
        for (Pair pair1 : pair) {
            System.out.println(pair1.getCrew1() + pair1.getCrew2() + pair1.getCrew3());
        }
        Assertions.assertEquals(10, pair.size());
    }
}
