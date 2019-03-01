package com.kodilla.kodillapatterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testOrderStandardPizzaGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(15), cost);
    }

    @Test
    public void testOrderStandardPizzaGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Standard pizza", description);
    }

    @Test
    public void testOrderPizzaWithExtraCheeseAndHamGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);

        //When
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(23), cost);
    }

    @Test
    public void testOrderPizzaWithExtraCheeseAndHamGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);


        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Standard pizza + extra cheese + ham", description);
    }
}
