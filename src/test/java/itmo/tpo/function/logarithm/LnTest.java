package itmo.tpo.function.logarithm;

import itmo.tpo.function.FunctionWithAccuracy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static itmo.tpo.FunctionWithAccuracyTestUtils.AssertThatExpression.assertThat;

public class LnTest {

    private final Ln ln = new Ln();

    @ParameterizedTest
    @ValueSource(doubles = {-2, -1, 0})
    void whenArgumentIsLessOrEqualZeroThenReturnsNan(Double argument) {
        assertThat(ln).appliedTo(argument).returns(Double.NaN);
    }

    @Test
    void whenArgumentIsGraterThanZeroAndCloseToZeroThenComputes() {
        assertThat(ln).appliedTo(0 + FunctionWithAccuracy.DEFAULT_ACCURACY).returns(-16.11809565095832);
    }

    @ParameterizedTest
    @CsvSource({
            "0.25,-1.3862943611198906",
            "0.5,-0.6931471805599453",
            "0.75,-0.2876820724517809"
    })
    void whenArgumentMoreThanZeroAndLessThanOneThenComputes(Double argument, Double expected) {
        assertThat(ln).appliedTo(argument).returns(expected);
    }

    @Test
    void whenArgumentIsOneThenReturnsZero() {
        assertThat(ln).appliedTo(1).returns(0);
    }

    @ParameterizedTest
    @CsvSource({
            "2,0.6931471805599453",
            "3,1.0986122886681098",
            "4,1.3862943611198906"
    })
    void whenArgumentIsGraterThanOneThenComputes(Double argument, Double expected) {
        assertThat(ln).appliedTo(argument).returns(expected);
    }
}
