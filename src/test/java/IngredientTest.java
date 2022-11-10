import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType ingredientType;
    private String name;
    private float price;
    private IngredientType expectedIngredientType;
    private String expectedName;
    private float expectedPrice;

    public IngredientTest(IngredientType ingredientType, String name, float price, IngredientType expectedIngredientType, String expectedName, float expectedPrice) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
        this.expectedIngredientType = expectedIngredientType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] parameterizedTest() {
        return new Object[][] {
                {IngredientType.SAUCE, "Начинка 1", 200.0f, IngredientType.SAUCE, "Начинка 1", 200.0f},
                {IngredientType.FILLING, "Начинка 2", 311.0f, IngredientType.FILLING, "Начинка 2", 311.0f},
                {IngredientType.SAUCE, "Начинка 3", 100.0f, IngredientType.SAUCE, "Начинка 3", 100.0f},
        };
    }

    @Test
    public void getTypeReturnsTypeOfIngredient() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(expectedIngredientType, ingredient.getType());
    }

    @Test
    public void getNameReturnsNameOfIngredient() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getPriceReturnsPriceOfIngredient() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }
}
