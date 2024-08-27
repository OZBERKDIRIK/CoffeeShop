package org.example;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeRecipeTest {
    @Test
    public void testGetName() {
        CoffeeRecipe recipe = new CoffeeRecipe("Espresso", Map.of("Espresso", 1));
        assertEquals("Espresso", recipe.getName(), "Sipariş Espresso olmalıydı");
    }

    @Test
    public void testPrepare() {
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        CoffeeRecipe recipe = new CoffeeRecipe("Espresso", Map.of("Espresso", 1));
        recipe.prepare();

        String output = outContent.toString().replace("\r\n", "\n").trim();
        String expectedOutput = "Espresso seçtiniz. Espresso içerisinde \n" +
                "1 doz Espresso içermektedir\n" +
                "Afiyet Olsun\n";

        expectedOutput = expectedOutput.replace("\r\n", "\n").trim();

        assertEquals(expectedOutput, output);

        System.setOut(System.out);
    }
}
