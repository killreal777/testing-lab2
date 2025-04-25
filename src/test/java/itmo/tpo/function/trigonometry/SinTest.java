package itmo.tpo.function.trigonometry;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static itmo.tpo.FunctionWithAccuracyTestUtils.AssertThatExpression.assertThat;
import static java.lang.Math.PI;

public class SinTest {

    private final Sin sin = new Sin();

    @ParameterizedTest
    @ValueSource(doubles = {-2 * PI, -1 * PI, 0, PI, 2 * PI})
    void whenArgumentIsMultipleOfPiThenReturnsZero(double argument) {
        assertThat(sin).appliedTo(argument).returns(0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-3.5 * PI, -1.5 * PI, 0.5 * PI, 2.5 * PI})
    void whenArgumentIsUpperExtremeThenReturnsOne(double argument) {
        assertThat(sin).appliedTo(argument).returns(1);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2.5 * PI, -0.5 * PI, 1.5 * PI, 3.5 * PI})
    void whenArgumentIsLowerExtremeThenReturnsMinusOne(double argument) {
        assertThat(sin).appliedTo(argument).returns(-1);
    }

    @ParameterizedTest
    @CsvSource({
            "0.5235987755982988, 0.5",        // π/6
            "0.7853981633974483, 0.70710678", // π/4
            "1.0471975511965976, 0.8660254",  // π/3
            "-5.235987755982989, 0.8660254",  // -5π/3
            "-5.497787143782138, 0.70710678", // -7π/4
            "-5.759586531581287, 0.5",        // -11π/6
    })
    void whenArgumentIsInFirstQuarterThenCalculates(double argument, double expected) {
        assertThat(sin).appliedTo(argument).returns(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "2.0943951023931953, 0.8660254",   // 2π/3
            "2.356194490192345, 0.70710678",   // 3π/4
            "2.617993877991494, 0.5",          // 5π/6
            "-3.665191429188092, 0.5",         // -7π/6
            "-3.9269908169872414, 0.70710678", // -5π/4
            "-4.1887902047863905, 0.8660254",  // -4π/3
            "-4.71238898038469, 1.0"           // -3π/2
    })
    void whenArgumentIsInSecondQuarterThenCalculates(double argument, double expected) {
        assertThat(sin).appliedTo(argument).returns(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "3.665191429188092, -0.5",         // 7π/6
            "3.9269908169872414, -0.70710678", // 5π/4
            "4.1887902047863905, -0.8660254",  // 4π/3
            "4.71238898038469, -1.0",          // 3π/2
            "-2.0943951023931953, -0.8660254", // -2π/3
            "-2.356194490192345, -0.70710678", // -3π/4
            "-2.617993877991494, -0.5",        // -5π/6
    })
    void whenArgumentIsInThirdQuarterThenCalculates(double argument, double expected) {
        assertThat(sin).appliedTo(argument).returns(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "5.235987755982989, -0.8660254",    // 5π/3
            "5.497787143782138, -0.70710678",   // 7π/4
            "5.759586531581287, -0.5",          // 11π/6
            "-0.5235987755982988, -0.5",        // -π/6
            "-0.7853981633974483, -0.70710678", // -π/4
            "-1.0471975511965976, -0.8660254"   // -π/3
    })
    void whenArgumentIsInForthQuarterThenCalculates(double argument, double expected) {
        assertThat(sin).appliedTo(argument).returns(expected);
    }
}
