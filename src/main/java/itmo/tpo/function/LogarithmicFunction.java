package itmo.tpo.function;

import itmo.tpo.function.logarithm.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogarithmicFunction implements FunctionWithAccuracy {

    private final Ln ln;
    private final Log2 log2;
    private final Log3 log3;
    private final Log5 log5;
    private final Log10 log10;

    public LogarithmicFunction() {
        this.ln = new Ln();
        this.log2 = new Log2(ln);
        this.log3 = new Log3(ln);
        this.log5 = new Log5(ln);
        this.log10 = new Log10(ln);
    }

    @Override
    public Double apply(Double x, Double accuracy) {
        double lnX = ln.apply(x, accuracy);
        double log2X = log2.apply(x, accuracy);
        double log3X = log3.apply(x, accuracy);
        double log5X = log5.apply(x, accuracy);
        double log10X = log10.apply(x, accuracy);

        return (((((log5X * log5X) - lnX) + log2X) - ((log3X + log10X) / log5X)) - log3X);
    }




























}
