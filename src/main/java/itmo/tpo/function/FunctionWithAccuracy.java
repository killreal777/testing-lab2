package itmo.tpo.function;

import java.util.function.BiFunction;

@FunctionalInterface
public interface FunctionWithAccuracy extends BiFunction<Double, Double, Double> {

    double DEFAULT_ACCURACY = 1e-6;

    @Override
    Double apply(Double x, Double accuracy);

    default double apply(double x) {
        return apply(x, DEFAULT_ACCURACY);
    }
}
