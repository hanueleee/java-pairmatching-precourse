package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PairGenerator {
    public List<String> crewNames;

    public PairGenerator(List<String> crewNames) {
        this.crewNames = crewNames;
    }

    public List<Pair> createPair() {
        List<Pair> pairs = new ArrayList<>();
        int cnt = 0;
        List<String> shuffle = Randoms.shuffle(crewNames);
        int size = shuffle.size();

        for (int i = 0; i < size - 1; i += 2) {
            Pair pair = new Pair(shuffle.get(i), shuffle.get(i + 1));
            pairs.add(pair);
            cnt++;
        }
        if (size % 2 != 0) {
            pairs.remove(cnt-1);
            Pair pair = new Pair(shuffle.get(size - 3), shuffle.get(size - 2), shuffle.get(size - 1));
            pairs.add(pair);
        }
        return pairs;
    }
}
