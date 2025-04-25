package itmo.tpo.function;

import itmo.tpo.function.trigonometry.Cos;
import itmo.tpo.function.trigonometry.Sin;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.Math.PI;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.AdditionalMatchers.eq;

import static itmo.tpo.FunctionWithAccuracyTestUtils.AssertThatExpression.assertThat;
import static org.mockito.Mockito.when;

public class CosTest {

    @Nested
    class RealFunctionTestKit extends TestKit {

        public RealFunctionTestKit() {
            super(new Cos(new Sin()));
        }
    }

    @Nested
    class MockedFunctionTestKit extends TestKit {

        private static Sin sin = mock(Sin.class);

        public MockedFunctionTestKit() {
            super(new Cos(sin));
        }

        @BeforeAll
        static void mockSin() {
            Stream.of(
                    provideAxisCrossTestData(),
                    provideUpperExtremeTestData(),
                    provideLowerExtremeTestData(),
                    provideFirstQuarterTestData(),
                    provideSecondQuarterTestData(),
                    provideThirdQuarterTestData(),
                    provideForthQuarterTestData()
            ).flatMap(Function.identity()).forEach(MockedFunctionTestKit::mockSin);
        }

        static void mockSin(TestData data) {
            when(sin.apply(eq(PI / 2 - data.argument, 0.0001), anyDouble())).thenReturn(data.cos);
            when(sin.apply(eq(data.argument, 0.0001), anyDouble())).thenReturn(data.sin);
        }
    }

    @RequiredArgsConstructor
    abstract static class TestKit {

        private final Cos cos;

        @ParameterizedTest
        @MethodSource("provideAxisCrossTestData")
        void whenArgumentIsAxisCrossThenReturnsZero(TestData data) {
            assertThat(cos).appliedTo(data.argument).returns(0);
        }

        static Stream<TestData> provideAxisCrossTestData() {
            return Stream.of(
                    new TestData(-1.5 * PI, -1.0, 0.0),
                    new TestData(-0.5 * PI, -1.0, 0.0),
                    new TestData(0.5 * PI, 1.0, 0.0),
                    new TestData(1.5 * PI, 1.0, 0.0)
            );
        }

        @ParameterizedTest
        @MethodSource("provideUpperExtremeTestData")
        void whenArgumentIsUpperExtremeThenReturnsOne(TestData data) {
            assertThat(cos).appliedTo(data.argument).returns(1);
        }

        static Stream<TestData> provideUpperExtremeTestData() {
            return Stream.of(
                    new TestData(-4 * PI, 0.0, 1.0),
                    new TestData(-2 * PI, 0.0, 1.0),
                    new TestData(0, 0.0, 1.0),
                    new TestData(2 * PI, 0.0, 1.0),
                    new TestData(4 * PI, 0.0, 1.0)
            );
        }

        @ParameterizedTest
        @MethodSource("provideLowerExtremeTestData")
        void whenArgumentIsLowerExtremeThenReturnsMinusOne(TestData data) {
            assertThat(cos).appliedTo(data.argument).returns(-1);
        }

        static Stream<TestData> provideLowerExtremeTestData() {
            return Stream.of(
                    new TestData(-3 * PI, 0.0, -1.0),
                    new TestData(-1 * PI, 0.0, -1.0),
                    new TestData(1 * PI, 0.0, -1.0),
                    new TestData(3 * PI, 0.0, -1.0)
            );
        }

        @ParameterizedTest
        @MethodSource("provideFirstQuarterTestData")
        void whenArgumentIsInFirstQuarterThenCalculates(TestData data) {
            assertThat(cos).appliedTo(data.argument).returns(data.cos);
        }

        static Stream<TestData> provideFirstQuarterTestData() {
            return Stream.of(
                    new TestData(1 * PI / 6, 0.5, Math.sqrt(3) / 2),
                    new TestData(1 * PI / 4, Math.sqrt(2) / 2, Math.sqrt(2) / 2),
                    new TestData(1 * PI / 3, Math.sqrt(3) / 2, 0.5),

                    new TestData(13 * PI / 6, 0.5, Math.sqrt(3) / 2),
                    new TestData(9 * PI / 4, Math.sqrt(2) / 2, Math.sqrt(2) / 2),
                    new TestData(7 * PI / 3, Math.sqrt(3) / 2, 0.5)
            );
        }

        @ParameterizedTest
        @MethodSource("provideSecondQuarterTestData")
        void whenArgumentIsInSecondQuarterThenCalculates(TestData data) {
            assertThat(cos).appliedTo(data.argument).returns(data.cos);
        }

        protected static Stream<TestData> provideSecondQuarterTestData() {
            return Stream.of(
                    new TestData(2 * PI / 3, Math.sqrt(3) / 2, -0.5),
                    new TestData(3 * PI / 4, Math.sqrt(2) / 2, -Math.sqrt(2) / 2),
                    new TestData(5 * PI / 6, 0.5, -Math.sqrt(3) / 2),
                    new TestData(8 * PI / 3, Math.sqrt(3) / 2, -0.5),
                    new TestData(11 * PI / 4, Math.sqrt(2) / 2, -Math.sqrt(2) / 2),
                    new TestData(17 * PI / 6, 0.5, -Math.sqrt(3) / 2)
            );
        }

        @ParameterizedTest
        @MethodSource("provideThirdQuarterTestData")
        void whenArgumentIsInThirdQuarterThenCalculates(TestData data) {
            assertThat(cos).appliedTo(data.argument).returns(data.cos);
        }

        static Stream<TestData> provideThirdQuarterTestData() {
            return Stream.of(
                    new TestData(7 * PI / 6, -0.5, -Math.sqrt(3) / 2),
                    new TestData(5 * PI / 4, -Math.sqrt(2) / 2, -Math.sqrt(2) / 2),
                    new TestData(4 * PI / 3, -Math.sqrt(3) / 2, -0.5),
                    new TestData(19 * PI / 6, -0.5, -Math.sqrt(3) / 2),
                    new TestData(13 * PI / 4, -Math.sqrt(2) / 2, -Math.sqrt(2) / 2),
                    new TestData(10 * PI / 3, -Math.sqrt(3) / 2, -0.5)
            );
        }

        @ParameterizedTest
        @MethodSource("provideForthQuarterTestData")
        void whenArgumentIsInForthQuarterThenCalculates(TestData data) {
            assertThat(cos).appliedTo(data.argument).returns(data.cos);
        }

        static Stream<TestData> provideForthQuarterTestData() {
            return Stream.of(
                    new TestData(5 * PI / 3, -Math.sqrt(3) / 2, 0.5),
                    new TestData(7 * PI / 4, -Math.sqrt(2) / 2, Math.sqrt(2) / 2),
                    new TestData(11 * PI / 6, -0.5, Math.sqrt(3) / 2),
                    new TestData(11 * PI / 3, -Math.sqrt(3) / 2, 0.5),
                    new TestData(15 * PI / 4, -Math.sqrt(2) / 2, Math.sqrt(2) / 2),
                    new TestData(23 * PI / 6, -0.5, Math.sqrt(3) / 2)
            );
        }
    }

    private record TestData(double argument, double sin, double cos) {
    }
}
