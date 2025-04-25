package itmo.tpo.function.logarithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static itmo.tpo.util.ResultDataResources.*;
import static itmo.tpo.util.AssertThatExpression.assertThat;
import static itmo.tpo.util.Mocks.mockLn;

public class Log10Test {

    private final Log10 log10Mocked = new Log10(mockLn());
    private final Log10 log10 = new Log10();

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideLog10ResultData")
    public void testLog10Mocked(ResultData data) {
        assertThat(log10Mocked).appliedTo(data.argument()).returns(data.result());
    }

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideLog10ResultData")
    public void testLog10(ResultData data) {
        assertThat(log10).appliedTo(data.argument()).returns(data.result());
    }
}
