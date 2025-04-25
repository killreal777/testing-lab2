package itmo.tpo.function.logarithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static itmo.tpo.util.AssertThatExpression.assertThat;
import static itmo.tpo.util.Mocks.mockLn;
import static itmo.tpo.util.ResultDataResources.ResultData;

public class Log5Test {

    private final Log5 log5Mocked = new Log5(mockLn());
    private final Log5 log5 = new Log5();

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideLog5ResultData")
    public void testLog5Mocked(ResultData data) {
        assertThat(log5Mocked).appliedTo(data.argument()).returns(data.result());
    }

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideLog5ResultData")
    public void testLog5(ResultData data) {
        assertThat(log5).appliedTo(data.argument()).returns(data.result());
    }
}
