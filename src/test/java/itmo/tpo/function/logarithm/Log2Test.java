package itmo.tpo.function.logarithm;

import itmo.tpo.util.ResultDataResources;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static itmo.tpo.util.AssertThatExpression.assertThat;
import static itmo.tpo.util.Mocks.mockLn;

public class Log2Test {

    private final Log2 log2Mocked = new Log2(mockLn());
    private final Log2 log2 = new Log2();

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideLog2ResultData")
    public void testLog2Mocked(ResultDataResources.ResultData data) {
        assertThat(log2Mocked).appliedTo(data.argument()).returns(data.result());
    }

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideLog2ResultData")
    public void testLog2(ResultDataResources.ResultData data) {
        assertThat(log2).appliedTo(data.argument()).returns(data.result());
    }
}
