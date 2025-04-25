package itmo.tpo.function.trigonometry;

import itmo.tpo.function.FunctionWithAccuracy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Sec implements FunctionWithAccuracy {

    private final Cos cos;

    public Sec() {
        this.cos = new Cos();
    }

    @Override
    public Double apply(Double x, Double accuracy) {
        var cosX = cos.apply(x, accuracy);
        if (cosX == 0) {
            return Double.NaN;
        }
        return 1 / cosX;
    }
}
