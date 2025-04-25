package itmo.tpo.function;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MainFunction implements FunctionWithAccuracy {

    private final LogarithmicFunction logarithmicFunction;
    private final TrigonometricFunction trigonometricFunction;

    public MainFunction() {
        this.logarithmicFunction = new LogarithmicFunction();
        this.trigonometricFunction = new TrigonometricFunction();
    }

    @Override
    public Double apply(Double x, Double accuracy) {
        if (x > 0) {
            return logarithmicFunction.apply(x, accuracy);
        } else {
            return trigonometricFunction.apply(x, accuracy);
        }
    }
}
