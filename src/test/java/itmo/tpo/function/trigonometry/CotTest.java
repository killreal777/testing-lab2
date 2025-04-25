package itmo.tpo.function.trigonometry;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static itmo.tpo.util.AssertThatExpression.assertThat;
import static itmo.tpo.util.Mocks.mockCos;
import static itmo.tpo.util.Mocks.mockSin;
import static itmo.tpo.util.ResultDataResources.ResultData;

public class CotTest {

    private final Cot cotMocked = new Cot(mockSin(), mockCos());
    private final Cot cot = new Cot();

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideCotResultData")
    public void testCotMocked(ResultData data) {
        assertThat(cotMocked).appliedTo(data.argument()).returns(data.result());
    }

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideCotResultData")
    public void testCot(ResultData data) {
        assertThat(cot).appliedTo(data.argument()).returns(data.result());
    }
}
