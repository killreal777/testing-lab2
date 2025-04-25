package itmo.tpo.function.trigonometry;

import itmo.tpo.util.ResultDataResources;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static itmo.tpo.util.AssertThatExpression.assertThat;
import static itmo.tpo.util.Mocks.*;

public class CscTest {

    private final Csc cscMocked = new Csc(mockSin());
    private final Csc csc = new Csc();

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideCscResultData")
    public void testCscMocked(ResultDataResources.ResultData data) {
        assertThat(cscMocked).appliedTo(data.argument()).returns(data.result());
    }

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideCscResultData")
    public void testCsc(ResultDataResources.ResultData data) {
        assertThat(csc).appliedTo(data.argument()).returns(data.result());
    }
}
