package itmo.tpo.function.trigonometry;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static itmo.tpo.util.AssertThatExpression.assertThat;
import static itmo.tpo.util.Mocks.mockSin;
import static itmo.tpo.util.ResultDataResources.ResultData;

public class CosTest {

    private final Cos cosMocked = new Cos(mockSin());
    private final Cos cos = new Cos();

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideCosResultData")
    public void testCosMocked(ResultData data) {
        assertThat(cosMocked).appliedTo(data.argument()).returns(data.result());
    }

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideCosResultData")
    public void testCos(ResultData data) {
        assertThat(cos).appliedTo(data.argument()).returns(data.result());
    }
}
