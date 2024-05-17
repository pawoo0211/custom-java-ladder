package line.domain;

import line.fixture.LineFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("라인 도메인 테스트")
public class LineTest {
    private LineFixture lineFixture;

    @BeforeEach
    void setUp() {
        lineFixture = new LineFixture();
    }

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
        Line line = lineFixture.라인_세로_가로_세로_빈_세로_가로_세로;

        Assertions.assertThat(line.hasPointAt(0)).isEqualTo(true);
    }

    @Test
    @DisplayName("해당 좌표가 가로 선이면 참을 세로 선이면 거짓을 반환한다.")
    void isRow() {
        Line line = lineFixture.라인_세로_가로_세로_빈_세로_가로_세로;

        assertAll(
                () -> Assertions.assertThat(line.isRow(0)).isEqualTo(false),
                () -> Assertions.assertThat(line.isRow(1)).isEqualTo(true)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 6})
    @DisplayName("참여 인원수가 4명일 때 4개의 세로 선을 생성한다.")
    void createColumn(int pointsIndex) {
        int 참가자_인원 = 4;
        Line line = new Line(참가자_인원);

        assertAll(
                () -> Assertions.assertThat(line.hasPointAt(pointsIndex)).isEqualTo(true),
                () -> Assertions.assertThat(line.isColumn(pointsIndex)).isEqualTo(true)
        );
    }
}
