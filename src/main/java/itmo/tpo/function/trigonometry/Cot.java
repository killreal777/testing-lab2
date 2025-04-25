package itmo.tpo.function.trigonometry;

import itmo.tpo.function.FunctionWithAccuracy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cot implements FunctionWithAccuracy {

    private final Sin sin;
    private final Cos cos;

    public Cot() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    @Override
    public Double apply(Double x, Double accuracy) {
        double sinX = sin.apply(x, accuracy);
        double cosX = cos.apply(x, accuracy);

        if (sinX == 0 || x % Math.PI == 0) {
            return Double.NaN;
        }

        return cosX / sinX;
    }
}
