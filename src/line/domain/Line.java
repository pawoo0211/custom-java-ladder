package line.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final int PLUS_POINT = 3;
    private static final Random random = new Random();
    private List<Boolean> points = new ArrayList<>();

    public Line (List<Boolean> points) {
        this.points = points;
    }

    public Line(int numberOfParticipant) {
        createColumns(numberOfParticipant);
        createRows();
    }

    private void createColumns(int numberOfParticipant) {
        int endLinePoint = numberOfParticipant + PLUS_POINT;
        IntStream.range(0, endLinePoint)
                .forEach(pointsIndex -> points.add(isColumn(pointsIndex)));
    }

    private void createRows() {
        int sideDistance = RowPoint.SIDE_DISTANCE.value;
        int lastRowPoint = points.size() - sideDistance;

        points.set(RowPoint.FIRST.value, random.nextBoolean());

        IntStream.range(RowPoint.SECOND.value, lastRowPoint)
                .filter(pointsIndex -> (isInitializeRow(pointsIndex)))
                .forEach(pointsIndex -> points.set(pointsIndex, true));
    }

    public int length() {
        return points.size();
    }

    public boolean hasPointAt(int point) {
        return points.get(point);
    }

    public boolean isRow(int point) {
        return (point % 2) == 1;
    }

    public boolean isColumn(int point) {
        return !isRow(point);
    }

    private boolean isInitializeRow(int point) {
        int sideDistance = RowPoint.SIDE_DISTANCE.value;

        if (isColumn(point)) {
            return false;
        }
        return !hasPointAt(point - sideDistance) && !hasPointAt(point + sideDistance);
    }

    private enum RowPoint {
        FIRST         (1),
        SECOND        (3),
        SIDE_DISTANCE (2)
        ;

        int value;

        RowPoint(int value) {
            this.value = value;
        }
    }
}
