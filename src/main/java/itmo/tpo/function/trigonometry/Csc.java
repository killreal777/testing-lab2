package itmo.tpo.function.trigonometry;

import itmo.tpo.function.FunctionWithAccuracy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Csc implements FunctionWithAccuracy {

    private final Sin sin;

    public Csc() {
        this.sin = new Sin();
    }

    @Override
    public Double apply(Double x, Double accuracy) {
        double sinX = sin.apply(x, accuracy);
        if (sinX == 0) {
            return Double.NaN;
        }
        return 1 / sinX;
    }
}
