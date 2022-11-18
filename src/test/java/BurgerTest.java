import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void setBunsBunObjectAssignsValueToTheBunVariable() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientIngredientObjectIngredientAddsToList() {
        burger.addIngredient(firstIngredient);
        assertTrue(burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void removeIngredientIndexOfIngredientRemovesIngredientFromListOfIngredients() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientIndexesOfIngredientsMovesIngredients() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1, 0);
        assertEquals(firstIngredient, burger.ingredients.get(1));
        assertEquals(secondIngredient, burger.ingredients.get(0));
    }

    @Test
    public void getPriceReturnsPriceOfBurger() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        Mockito.when(bun.getPrice()).thenReturn(50.0f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(100.0f);
        assertEquals(200.0, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptReturnsReceiptOfBurger() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        Mockito.when(bun.getPrice()).thenReturn(50.0f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(60.0f);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("ketchup");
        String expected = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", bun.getName(), firstIngredient.getType().toString().toLowerCase(),
                firstIngredient.getName(), bun.getName(), burger.getPrice());
        assertEquals(expected, burger.getReceipt());
    }

}
