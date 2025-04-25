package itmo.tpo.function.logarithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static itmo.tpo.util.AssertThatExpression.assertThat;
import static itmo.tpo.util.Mocks.mockLn;
import static itmo.tpo.util.ResultDataResources.ResultData;

public class Log3Test {

    private final Log3 log3Mocked = new Log3(mockLn());
    private final Log3 log3 = new Log3();

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideLog3ResultData")
    public void testLog3Mocked(ResultData data) {
        assertThat(log3Mocked).appliedTo(data.argument()).returns(data.result());
    }

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideLog3ResultData")
    public void testLog3(ResultData data) {
        assertThat(log3).appliedTo(data.argument()).returns(data.result());
    }
}
