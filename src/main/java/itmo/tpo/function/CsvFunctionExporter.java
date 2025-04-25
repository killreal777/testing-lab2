package itmo.tpo.function;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.DoubleStream;

public class CsvFunctionExporter {

    public void exportFunctionResults(FunctionWithAccuracy function, double accuracy, DoubleRange range) {
        String functionName = function.getClass().getSimpleName();
        String header = String.format("x %s(x)", functionName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("target/output.csv"))) {
            writer.write(header + '\n');
            range.doubleStream()
                    .mapToObj(x -> x + " " + function.apply(x, accuracy))
                    .forEach(line -> {
                        try {
                            writer.write(line);
                            writer.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public record DoubleRange(double start, double stop, double step) {

        DoubleStream doubleStream() {
            return DoubleStream.iterate(start, x -> x < stop, x -> x + step);
        }
    }
}
