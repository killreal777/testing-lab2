package itmo.tpo.function.logarithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static itmo.tpo.FunctionWithAccuracyTestUtils.AssertThatExpression.assertThat;
import static org.mockito.AdditionalMatchers.eq;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static java.lang.Double.NaN;

public class LogTest {

    private static final Ln LN = mock(Ln.class);

    private static final double ARGUMENT = 555.0;
    private static final double BASE = 777.0;

    private final double base;
    private final Log log;

    protected double base() {
        return BASE;
    }

    public LogTest() {
        this.base = base();
        this.log = new Log(LN, base);
    }

    @Test
    void whenLnIsNullThenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Log(null, 1));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2, -1, 0, 1})
    void whenLogBaseLessOrEqualZeroOrEqualOneThenThrowsIllegalArgumentException(double base) {
        assertThrows(IllegalArgumentException.class, () -> new Log(LN, base));
        assertThrows(IllegalArgumentException.class, () -> new Log(base));
    }

    @Test
    void whenLnOfArgumentIsNanThenReturnsNan() {
        mockLn(ARGUMENT, NaN);
        assertThat(log).appliedTo(ARGUMENT).returns(NaN);
    }

    @Test
    void whenLnOfBaseIsNanThenReturnsNan() {
        mockLn(base, NaN);
        assertThat(log).appliedTo(ARGUMENT).returns(NaN);
    }

    @ParameterizedTest
    @CsvSource({"5d,2d", "-1d,0.5", "7.1,-9d", "-3,-7.5"})
    void whenLnOfArgumentAndBaseAreNotNanThenComputesDivision(
            double resultOfLnOfArgument,
            double resultOfLnOfBase
    ) {
        mockLn(ARGUMENT, resultOfLnOfArgument);
        mockLn(base, resultOfLnOfBase);
        double result = resultOfLnOfArgument / resultOfLnOfBase;
        assertThat(log).appliedTo(ARGUMENT).returns(result);
    }

    static void mockLn(double argument, double answer) {
        when(LN.apply(eq(argument, 0), anyDouble())).thenReturn(answer);
    }
}
