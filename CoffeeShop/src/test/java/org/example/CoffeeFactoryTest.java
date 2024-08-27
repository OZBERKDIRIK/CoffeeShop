package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoffeeFactoryTest {
    @BeforeEach
    public void setUp() {
        CoffeeFactory.clearRecipes();
    }

    @AfterEach
    public void tearDown() {
        CoffeeFactory.clearRecipes();
    }
    @Test
    public void testGetCoffee() {
        CoffeeRecipe espresso = new CoffeeRecipe("Espresso", Map.of("Espresso", 1));
        CoffeeFactory.addCoffee(1, espresso);

        CoffeeRecipe result = CoffeeFactory.getCoffee(1);
        assertNotNull(result, "CoffeeRecipe should not be null");
        assertEquals("Espresso", result.getName(), "CoffeeRecipe name should be 'Espresso'");
    }


    @Test
    public void testListCoffees() {
        CoffeeRecipe espresso = new CoffeeRecipe("Espresso", Map.of("Espresso", 1));
        CoffeeFactory.addCoffee(1, espresso);

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        CoffeeFactory.listCoffees();

        String output = outContent.toString().replace("\r\n", "\n").trim();

        String expectedOutput = "1: Espresso\n";
        expectedOutput = expectedOutput.replace("\r\n", "\n").trim();
        assertEquals(expectedOutput, output);

        System.setOut(System.out);
    }

    @Test
    public void testAddCoffee() {
        CoffeeRecipe newRecipe = new CoffeeRecipe("Latte", Map.of("Espresso", 1, "Milk", 2));
        CoffeeFactory.addCoffee(8, newRecipe);

        CoffeeRecipe result = CoffeeFactory.getCoffee(8);
        assertNotNull(result, "CoffeeRecipe null olmamalı");
        assertEquals("Latte", result.getName(), "CoffeeRecipe 'Latte' olmalı");
    }

    @Test
    public void testAddCoffeeDuplicateType() {
        CoffeeRecipe espresso = new CoffeeRecipe("Espresso", Map.of("Espresso", 1));
        CoffeeFactory.addCoffee(1, espresso);

        CoffeeRecipe anotherRecipe = new CoffeeRecipe("Double Espresso", Map.of("Espresso", 2));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CoffeeFactory.addCoffee(1, anotherRecipe);
        });

        assertEquals("Kahve zaten eklenmiş", exception.getMessage());
    }
}
