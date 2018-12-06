package com.kodilla.spring.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        double a = 20.0;
        double b = 5.0;

        ApplicationContext context =
                new AnnotationConfigApplicationContext();
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double add = calculator.add(a, b);
        double sub = calculator.sub(a, b);
        double mul = calculator.mul(a, b);
        double div = calculator.div(a, b);


    }
}
