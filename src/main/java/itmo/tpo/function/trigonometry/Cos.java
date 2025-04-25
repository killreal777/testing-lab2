package itmo.tpo.function.trigonometry;

import itmo.tpo.function.FunctionWithAccuracy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cos implements FunctionWithAccuracy {

    private final Sin sin;

    public Cos() {
        this.sin = new Sin();
    }

    @Override
    public Double apply(Double x, Double accuracy) {
        return sin.apply(Math.PI / 2 - x, accuracy);
    }
}
