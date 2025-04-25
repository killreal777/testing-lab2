package itmo.tpo.function;

import itmo.tpo.function.trigonometry.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrigonometricFunction implements FunctionWithAccuracy {

    private final Cos cos;
    private final Cot cot;
    private final Csc csc;
    private final Sec sec;
    private final Sin sin;
    private final Tan tan;

    public TrigonometricFunction() {
        this.cos = new Cos();
        this.cot = new Cot();
        this.csc = new Csc();
        this.sec = new Sec();
        this.sin = new Sin();
        this.tan = new Tan();
    }

    @Override
    public Double apply(Double x, Double accuracy) {
        double cosX = cos.apply(x, accuracy);
        double cotX = cot.apply(x, accuracy);
        double cscX = csc.apply(x, accuracy);
        double secX = sec.apply(x, accuracy);
        double sinX = sin.apply(x, accuracy);
        double tanX = tan.apply(x, accuracy);

        return ((((pow2((((((((pow2(cscX - cotX)) + (sinX / tanX)) * tanX) + tanX) + sinX) / ((secX - (tanX
                * cosX)) + cosX)) + (((secX - (pow3(tanX) / (secX / sinX))) * cscX) + cosX)) - (sinX * secX))) / ((secX
                * ((cotX + (tanX - cscX)) + (cotX * (cosX / sinX)))) + tanX)) - ((tanX * ((cosX * ((secX + secX)
                * sinX)) + (cotX / ((pow3(tanX) / (pow2(cosX + cosX))) + (pow3(secX) - pow3(cosX)))))) - secX))
                / ((pow2(tanX - sinX)) - cscX));
    }

    private double pow2(double x) {
        return Math.pow(x, 2);
    }

    private double pow3(double x) {
        return Math.pow(x, 3);
    }
}
