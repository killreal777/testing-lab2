package itmo.tpo.function;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UtilityClass
public class FunctionWithAccuracyTestUtils {

    private static void testAccuracy(FunctionWithAccuracy function, double expected, double argument) {
        assertEquals(expected, function.apply(argument), FunctionWithAccuracy.DEFAULT_ACCURACY);
    }

    public static class AssertThatExpression {
        private FunctionWithAccuracy function;
        private double argument;

        public static AppliedToStage assertThat(FunctionWithAccuracy function) {
            AssertThatExpression expression = new AssertThatExpression();
            expression.function = function;
            return new AppliedToStage(expression);
        }

        @RequiredArgsConstructor
        public static class AppliedToStage {
            private final AssertThatExpression expression;

            public ShouldReturnStage appliedTo(double argument) {
                expression.argument = argument;
                return new ShouldReturnStage(expression);
            }
        }

        @RequiredArgsConstructor
        public static class ShouldReturnStage {
            private final AssertThatExpression expression;

            public void returns(double expected) {
                testAccuracy(expression.function, expected, expression.argument);
            }
        }
    }
}
