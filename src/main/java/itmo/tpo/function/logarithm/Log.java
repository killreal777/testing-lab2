package itmo.tpo.function.logarithm;

import itmo.tpo.function.FunctionWithAccuracy;

public class Log implements FunctionWithAccuracy {

    private final Ln ln;
    private final double base;

    public Log(Ln ln, double base) {
        if (ln == null) {
            throw new IllegalArgumentException("ln must not be null");
        }
        if (base <= 0) {
            throw new IllegalArgumentException("base must be greater than zero");
        }
        if (base == 1) {
            throw new IllegalArgumentException("base must not be 1");
        }
        this.ln = ln;
        this.base = base;
    }

    public Log(double base) {
        this(new Ln(), base);
    }

    @Override
    public Double apply(Double x, Double accuracy) {
        return ln.apply(x, accuracy) / ln.apply(base, accuracy);
    }
}
