package itmo.tpo.function;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogarithmicFunction implements FunctionWithAccuracy {

    private final itmo.tpo.function.logarithm.Ln ln;
    private final itmo.tpo.function.logarithm.Log2 log2;
    private final itmo.tpo.function.logarithm.Log3 log3;
    private final itmo.tpo.function.logarithm.Log5 log5;
    private final itmo.tpo.function.logarithm.Log10 log10;

    public LogarithmicFunction() {
        this.ln = new itmo.tpo.function.logarithm.Ln();
        this.log2 = new itmo.tpo.function.logarithm.Log2(ln);
        this.log3 = new itmo.tpo.function.logarithm.Log3(ln);
        this.log5 = new itmo.tpo.function.logarithm.Log5(ln);
        this.log10 = new itmo.tpo.function.logarithm.Log10(ln);
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
