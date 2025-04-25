package itmo.tpo.function.trigonometry;

import itmo.tpo.function.FunctionWithAccuracy;

public class Sin implements FunctionWithAccuracy {

    @Override
    public Double apply(Double x, Double accuracy) {
        double term = x;
        double sum = term;
        int i = 1;
        while (Math.abs(term) > accuracy) {
            term *= -x * x / ((2 * i) * (2 * i + 1));
            sum += term;
            i++;
        }
        return sum;
    }
}
