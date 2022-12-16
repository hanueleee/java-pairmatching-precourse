package pairmatching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.domain.PairMatcher;
import pairmatching.enums.Course;
import pairmatching.repository.PairRecordRepository;

import java.util.List;

public class PairMatcherTest {
    public PairRecordRepository pairRecordRepository = new PairRecordRepository();
    public PairMatcher pairMatcher = new PairMatcher(pairRecordRepository);

    @Test
    void 파일_입출력_백엔드() {
        try {
            List<String> crewNames = pairMatcher.getCrewNames(Course.BACKEND.getLabel());
            Assertions.assertEquals(20, crewNames.size());
            Assertions.assertEquals("백호", crewNames.get(0));
            Assertions.assertEquals("달재", crewNames.get(19));
        } catch (Exception e) {
            System.out.println("파일이 없습니다.");
        }
    }
}
