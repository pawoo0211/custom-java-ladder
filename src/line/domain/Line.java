package line.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int PLUS_POINT = 3;
    private List<Boolean> points = new ArrayList<>();

    public Line (List<Boolean> points) {
        this.points = points;
    }

    public Line(int numberOfParticipant) {
        initializePoints(numberOfParticipant);
    }

    private void initializePoints(int numberOfParticipant) {
        int endLinePoint = numberOfParticipant + PLUS_POINT;
        IntStream.range(0, endLinePoint)
                .forEach(number -> points.add(false));
    }

    public int length() {
        return points.size();
    }

    public boolean hasPointAt(int pointsIndex) {
        return points.get(pointsIndex);
    }

    public boolean isRow(int pointsIndex) {
        return (pointsIndex % 2) == 1;
    }

    public boolean isColumn(int pointsIndex) {
        return !isRow(pointsIndex);
    }
}
