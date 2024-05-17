package line;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("라인 도메인 테스트")
public class LineTest {

    @Test
    @DisplayName("x축 최대 좌표 값은 참여 인원 + 3이다.")
    void init_pointsSize() {
        int 참가자_인원 = 4;

        Line line = new Line(참가자_인원);
        Assertions.assertThat(line.length()).isEqualTo(참가자_인원 + 3);
    }

    @Test
    @DisplayName("좌표 값에 선이 있으면 참을 반환하며 없으면 거짓을 반환한다.")
    void has() {
        List<Boolean> points = List.of(true, true, true, false, true, false, true);
        Line line = new Line(points);

        Assertions.assertThat(line.hasPointAt(0)).isEqualTo(true);
    }

    @Test
    @DisplayName("해당 좌표가 가로 선이면 참을 세로 선이면 거짓을 반환한다.")
    void isRow() {
        List<Boolean> points = List.of(true, true, true, false, true, false, true);
        Line line = new Line(points);

        assertAll(
                () -> Assertions.assertThat(line.isRow(0)).isEqualTo(false),
                () -> Assertions.assertThat(line.isRow(1)).isEqualTo(true)
        );
    }

    class Line {
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
}
