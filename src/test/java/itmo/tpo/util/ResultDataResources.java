package itmo.tpo.util;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import itmo.tpo.function.FunctionWithAccuracy;
import itmo.tpo.function.LogarithmicFunction;
import itmo.tpo.function.TrigonometricFunction;
import itmo.tpo.function.logarithm.*;
import itmo.tpo.function.trigonometry.*;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.util.List;

@UtilityClass
public class ResultDataResources {

    public static List<ResultData> provideLnResultData() {
        return read(Ln.class);
    }

    public static List<ResultData> provideLog2ResultData() {
        return read(Log2.class);
    }

    public static List<ResultData> provideLog3ResultData() {
        return read(Log3.class);
    }

    public static List<ResultData> provideLog5ResultData() {
        return read(Log5.class);
    }

    public static List<ResultData> provideLog10ResultData() {
        return read(Log10.class);
    }

    public static List<ResultData> provideSinResultData() {
        return read(Sin.class);
    }

    public static List<ResultData> provideCosResultData() {
        return read(Cos.class);
    }

    public static List<ResultData> provideTanResultData() {
        return read(Tan.class);
    }

    public static List<ResultData> provideCotResultData() {
        return read(Cot.class);
    }

    public static List<ResultData> provideSecResultData() {
        return read(Sec.class);
    }

    public static List<ResultData> provideCscResultData() {
        return read(Csc.class);
    }

    public static List<ResultData> provideLogarithmicFunctionResultData() {
        return read(LogarithmicFunction.class);
    }

    public static List<ResultData> provideTrigonometricFunctionResultData() {
        return read(TrigonometricFunction.class);
    }

    @SneakyThrows
    public static List<ResultData> read(Class<? extends FunctionWithAccuracy> functionClass) {
        String resourceName = functionClass.getSimpleName().toLowerCase() + ".csv";
        return read(resourceName);
    }

    @SneakyThrows
    public static List<ResultData> read(String resourceName) {
        File file = new File(ResultDataResources.class.getClassLoader().getResource(resourceName).toURI());
        return read(file);
    }

    @SneakyThrows
    public static List<ResultData> read(File file) {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(ResultData.class);
        MappingIterator<ResultData> iterator = mapper
                .readerFor(ResultData.class)
                .with(schema)
                .readValues(file);
        try (iterator) {
            return iterator.readAll();
        }
    }

    @JsonPropertyOrder({"argument", "result"})
    public record ResultData(double argument, double result) {
    }
}
