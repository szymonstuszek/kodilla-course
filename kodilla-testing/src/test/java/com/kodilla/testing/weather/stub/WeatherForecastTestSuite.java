package com.kodilla.testing.weather.stub;

import org.junit.Assert;
import org.junit.Test;

public class WeatherForecastTestSuite {

    @Test
    public void testCalculateForecastWithStub() {

        Temperatures temperatures = new TemperaturesStub();

        WeatherForecast weatherForecast = new WeatherForecast(temperatures);

        int quantityOfSensors = weatherForecast.calculateForecast().size();

        Assert.assertEquals(5, quantityOfSensors);
    }

}
