package itmo.tpo.function.trigonometry;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static itmo.tpo.util.AssertThatExpression.assertThat;
import static itmo.tpo.util.Mocks.mockCos;
import static itmo.tpo.util.ResultDataResources.ResultData;

public class SecTest {

    private final Sec secMocked = new Sec(mockCos());
    private final Sec sec = new Sec();

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideSecResultData")
    public void testSecMocked(ResultData data) {
        assertThat(secMocked).appliedTo(data.argument()).returns(data.result());
    }

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideSecResultData")
    public void testSec(ResultData data) {
        assertThat(sec).appliedTo(data.argument()).returns(data.result());
    }
}
