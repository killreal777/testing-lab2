package itmo.tpo.util;

import itmo.tpo.function.FunctionWithAccuracy;
import itmo.tpo.function.LogarithmicFunction;
import itmo.tpo.function.TrigonometricFunction;
import itmo.tpo.function.logarithm.*;
import itmo.tpo.function.trigonometry.*;
import lombok.experimental.UtilityClass;

import static org.mockito.AdditionalMatchers.eq;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@UtilityClass
public class Mocks {

    public static Ln mockLn() {
        Ln ln = mock(Ln.class);
        mockWithCsvResultData(ln, "ln.csv");
        return ln;
    }

    public static Log2 mockLog2() {
        Log2 log2 = mock(Log2.class);
        mockWithCsvResultData(log2, "log2.csv");
        return log2;
    }

    public static Log3 mockLog3() {
        Log3 log3 = mock(Log3.class);
        mockWithCsvResultData(log3, "log3.csv");
        return log3;
    }

    public static Log5 mockLog5() {
        Log5 log5 = mock(Log5.class);
        mockWithCsvResultData(log5, "log5.csv");
        return log5;
    }

    public static Log10 mockLog10() {
        Log10 log10 = mock(Log10.class);
        mockWithCsvResultData(log10, "log10.csv");
        return log10;
    }

    public static Sin mockSin() {
        Sin sin = mock(Sin.class);
        mockWithCsvResultData(sin, "sin.csv");
        return sin;
    }

    public static Cos mockCos() {
        Cos cos = mock(Cos.class);
        mockWithCsvResultData(cos, "cos.csv");
        return cos;
    }

    public static Tan mockTan() {
        Tan tan = mock(Tan.class);
        mockWithCsvResultData(tan, "tan.csv");
        return tan;
    }

    public static Cot mockCot() {
        Cot cot = mock(Cot.class);
        mockWithCsvResultData(cot, "cot.csv");
        return cot;
    }

    public static Sec mockSec() {
        Sec sec = mock(Sec.class);
        mockWithCsvResultData(sec, "sec.csv");
        return sec;
    }

    public static Csc mockCsc() {
        Csc csc = mock(Csc.class);
        mockWithCsvResultData(csc, "csc.csv");
        return csc;
    }

    public static LogarithmicFunction mockLogarithmicFunction() {
        LogarithmicFunction logarithmic = mock(LogarithmicFunction.class);
        mockWithCsvResultData(logarithmic, "logarithmic.csv");
        return logarithmic;
    }

    public static TrigonometricFunction mockTrigonometricFunction() {
        TrigonometricFunction trigonometricFunction = mock(TrigonometricFunction.class);
        mockWithCsvResultData(trigonometricFunction, "trigonometric.csv");
        return trigonometricFunction;
    }

    private static void mockWithCsvResultData(FunctionWithAccuracy function, String resourceName) {
        ResultDataResources.read(resourceName).forEach(data ->
                when(function.apply(eq(data.argument(), 0.001), anyDouble())).thenReturn(data.result())
        );
    }
}
