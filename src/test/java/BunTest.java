import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;
    private String expectedName;
    private float expectedPrice;

    public BunTest(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] parameterizedTest() {
        return new Object[][] {
                {"Черная булка", 50f, "Черная булка", 50f},
                {"Белая булка", 75f,"Белая булка", 75f}
        };
    }

    @Test
    public void getNameReturnsNameOfBun() {
        Bun bun = new Bun(name, price);
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPriceReturnsPriceOfBun() {
        Bun bun = new Bun(name, price);
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
