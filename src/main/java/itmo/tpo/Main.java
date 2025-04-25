package itmo.tpo;

import itmo.tpo.function.CsvFunctionExporter;
import itmo.tpo.function.FunctionWithAccuracy;
import itmo.tpo.function.logarithm.*;
import itmo.tpo.function.trigonometry.*;
import itmo.tpo.function.*;

public class Main {

    public static void main(String[] args) {
        CsvFunctionExporter exporter = new CsvFunctionExporter();
        FunctionWithAccuracy function = new MainFunction();
        double accuracy = 1E-6;
        CsvFunctionExporter.DoubleRange range = new CsvFunctionExporter.DoubleRange(-5, 5, 0.1);
        exporter.exportFunctionResults(function, accuracy, range);
    }
}
