package itmo.tpo.function.logarithm;

import itmo.tpo.function.FunctionWithAccuracy;

public class Ln implements FunctionWithAccuracy {

    @Override
    public Double apply(Double x, Double accuracy) {
        if (x <= 0) {
            return Double.NaN;
        }

        double y = (x - 1) / (x + 1);
        double sum = 0.0;
        double term = y;
        int n = 1;

        while (Math.abs(term) > accuracy) {
            sum += term / (2 * n - 1);
            term *= y * y;
            n++;
        }
        return 2 * sum;
    }
}
