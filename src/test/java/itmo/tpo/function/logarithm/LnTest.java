package itmo.tpo.function.logarithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static itmo.tpo.util.AssertThatExpression.assertThat;
import static itmo.tpo.util.ResultDataResources.ResultData;

public class LnTest {

    private final Ln ln = new Ln();

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideLnResultData")
    public void testLn(ResultData data) {
        assertThat(ln).appliedTo(data.argument()).returns(data.result());
    }
}