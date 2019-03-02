package com.kodilla.kodillapatterns2.aop.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Test
    public void testAdd() {
        //Given
        //When
        double result = calculator.add(10, 15);

        //Then
        LOGGER.info("Testing add method");
        assertEquals(result, 25.0, 0);
    }

    @Test
    public void testSub() {
        //Given
        //When
        double result = calculator.sub(10, 15);

        //Then
        LOGGER.info("Testing sub method");
        assertEquals(result, -5.0, 0);
    }

    @Test
    public void testMul() {
        //Given
        //When
        double result = calculator.mul(10, 15);

        //Then
        LOGGER.info("Testing mul method");
        assertEquals(result, 150, 0);
    }

    @Test
    public void testDiv() {
        //Given
        //When
        double result = calculator.div(15, 5);

        //Then
        LOGGER.info("Testing div method");
        assertEquals(result, 3, 0);
    }

    @Test
    public void testFactorial() {
        //Given
        //When
        BigDecimal result = calculator.factorial(new BigDecimal(1000));

        //Then
        LOGGER.info("Testing factorial method");
        assertTrue(BigDecimal.ONE.compareTo(result) < 0);
    }


}
