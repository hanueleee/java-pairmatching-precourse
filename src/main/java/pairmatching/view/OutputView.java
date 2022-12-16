package pairmatching.view;

import pairmatching.domain.Pair;

import java.util.List;

public class OutputView {
    public final String OPTION = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";

    public final String COURSE_AND_MISSION = "#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "############################################\n";

    public final String ASK_REMATCH = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";
    public final String RESULT = "페어 매칭 결과입니다.";
    public final String RESET = "초기화 되었습니다.";
    public void printOption() {
        System.out.println(OPTION);
    }

    public void printCourseAndMisson() {
        System.out.println(COURSE_AND_MISSION);
    }

    public void printRematch() {
        System.out.println(ASK_REMATCH);
    }

    public void printMissionPair(List<Pair> pairs) {
        System.out.println(RESULT);
        for (Pair pair : pairs) {
            if (pair.getCrew3().isEmpty()) {
                System.out.println(pair.getCrew1() + " : " + pair.getCrew2());
                continue;
            }
            System.out.println(pair.getCrew1() + " : " + pair.getCrew2() + " : " +pair.getCrew3());
        }
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printResetComplete() {
        System.out.println(RESET);
    }
}
