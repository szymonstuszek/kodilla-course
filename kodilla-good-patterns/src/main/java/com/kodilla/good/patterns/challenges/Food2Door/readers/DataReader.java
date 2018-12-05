package com.kodilla.good.patterns.challenges.Food2Door.readers;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static List<String[]> readAll(Reader reader) {

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(0)
                .withCSVParser(parser)
                .build();

        List<String[]> list = new ArrayList<>();
        try {
            list = csvReader.readAll();
            reader.close();
            csvReader.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return list;
    }

    public static Path twoColumnCsvPath() throws URISyntaxException {
        URI uri = ClassLoader.getSystemResource("products.csv").toURI();
        return Paths.get(uri);
    }

    public static List<String[]> readAllSyncExample() {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(twoColumnCsvPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return DataReader.readAll(reader);
    }
}
