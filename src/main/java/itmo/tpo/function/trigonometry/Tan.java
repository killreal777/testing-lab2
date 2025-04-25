package itmo.tpo.function.trigonometry;

import itmo.tpo.function.FunctionWithAccuracy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Tan implements FunctionWithAccuracy {

    private final Sin sin;
    private final Cos cos;

    public Tan() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    @Override
    public Double apply(Double x, Double accuracy) {
        var sinX = sin.apply(x, accuracy);
        var cosX = cos.apply(x, accuracy);

        if (cosX == 0) {
            return Double.NaN;
        }

        return sinX / cosX;
    }
}
