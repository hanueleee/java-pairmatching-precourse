package pairmatching.domain;

import pairmatching.enums.Course;
import pairmatching.enums.Level;

import java.util.List;

public class PairRecord {
    private Course course;
    private Level level;
    private String mission;
    private List<Pair> pairs;

    public PairRecord(Course course, Level level, String mission, List<Pair> pairs) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairs = pairs;
    }
}
