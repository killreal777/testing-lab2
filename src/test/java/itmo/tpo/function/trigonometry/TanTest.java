package itmo.tpo.function.trigonometry;

import itmo.tpo.util.ResultDataResources;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static itmo.tpo.util.AssertThatExpression.assertThat;
import static itmo.tpo.util.Mocks.mockCos;
import static itmo.tpo.util.Mocks.mockSin;
import static itmo.tpo.util.ResultDataResources.ResultData;

public class TanTest {

    private final Tan tanMocked = new Tan(mockSin(), mockCos());
    private final Tan tan = new Tan();

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideTanResultData")
    public void testTanMocked(ResultData data) {
        assertThat(tanMocked).appliedTo(data.argument()).returns(data.result());
    }

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideTanResultData")
    public void testTan(ResultData data) {
        assertThat(tan).appliedTo(data.argument()).returns(data.result());
    }
}
