package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    public void testBuilder() {

        //Given
        Bigmac bigmacBuild = new Bigmac.BigmacBuilder()
                .bun("roll")
                .sauce("spicy")
                .ingredient("cheese")
                .ingredient("salad")
                .ingredient("ham")
                .burgers(2)
                .build();
        System.out.println(bigmacBuild);

        //When
        int howManyIngredients = bigmacBuild.getIngredients().size();

        //Then
        assertEquals(3, howManyIngredients);

    }
}
