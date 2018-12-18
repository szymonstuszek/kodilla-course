package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Regular")
                .burgers(1)
                .sauce(Sauce.BARBECUE)
                .ingredients(Ingredient.BECON)
                .ingredients(Ingredient.CHEESE)
                .ingredients(Ingredient.SALAD)
                .build();
        //When
        int numberOfIngredients = bigmac.getIngredients().size();

        //Then
        Assert.assertEquals(3, numberOfIngredients);
        Assert.assertEquals("BARBECUE", bigmac.getSauce());
        Assert.assertEquals(1, bigmac.getBurgers());
    }
}
