package itmo.tpo.function.trigonometry;

import itmo.tpo.util.ResultDataResources;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static itmo.tpo.util.AssertThatExpression.assertThat;

public class SinTest {

    private final Sin sin = new Sin();

    @ParameterizedTest
    @MethodSource("itmo.tpo.util.ResultDataResources#provideSinResultData")
    public void testLn(ResultDataResources.ResultData data) {
        assertThat(sin).appliedTo(data.argument()).returns(data.result());
    }
}
