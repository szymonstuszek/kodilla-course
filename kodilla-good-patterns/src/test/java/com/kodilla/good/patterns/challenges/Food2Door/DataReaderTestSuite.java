package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.readers.DataReader;
import org.junit.Test;

import java.util.List;

public class DataReaderTestSuite {

    @Test
    public void testReadAll() {
        List<String[]> data = DataReader.readAllSyncExample();
        System.out.println(data.get(0).toString());
    }
}
