package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country poland = new Country(new BigDecimal("40"));
        Country japan = new Country(new BigDecimal("40"));
        Country usa = new Country(new BigDecimal("120"));

        List<Country> countriesInEurope = new ArrayList<>();
        List<Country> countriesInAsia = new ArrayList<>();
        List<Country> countriesInAmerica = new ArrayList<>();

        countriesInEurope.add(poland);
        countriesInAsia.add(japan);
        countriesInAmerica.add(usa);

        Continent europe = new Continent(countriesInEurope);
        Continent asia = new Continent(countriesInAsia);
        Continent america = new Continent(countriesInAmerica);

        List<Continent> continents = new ArrayList<>();
        continents.add(europe);
        continents.add(asia);
        continents.add(america);

        World world = new World(continents);

        //When
        BigDecimal quantityOfPeople = world.getPeopleQuantity();

        //Then
        BigDecimal expectedQuantityOfPeople = new BigDecimal("200");
        Assert.assertEquals(expectedQuantityOfPeople, quantityOfPeople);
    }
}
