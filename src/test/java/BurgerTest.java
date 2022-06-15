import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    private float bunPrice = 200.0F;
    private String bunName = "Вкусная булочка";

    @Mock
    private Ingredient sauceIngredient;
    private String sauceIngredientName = "tobasco";
    private float sauceIngredientPrice = 70.0F;

    @Mock
    private Ingredient fillingIngredient;
    private String fillingIngredientName = "cheese";
    private float fillingIngredientPrice = 30.0F;

    @Before
    public void prepare() {
        when(this.bun.getPrice()).thenReturn(this.bunPrice);
        when(this.bun.getName()).thenReturn(this.bunName);

        when(this.sauceIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(this.sauceIngredient.getName()).thenReturn(this.sauceIngredientName);
        when(this.sauceIngredient.getPrice()).thenReturn(this.sauceIngredientPrice);

        when(this.fillingIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(this.fillingIngredient.getName()).thenReturn(this.fillingIngredientName);
        when(this.fillingIngredient.getPrice()).thenReturn(this.fillingIngredientPrice);
    }

    @Test
    public void addIngredientsTest() {
        Burger burger = new Burger();
        burger.addIngredient(this.sauceIngredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientsTest() {
        Burger burger = new Burger();
        burger.addIngredient(this.sauceIngredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(this.sauceIngredient);
        burger.addIngredient(this.fillingIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(this.sauceIngredient, burger.ingredients.get(1));
    }

    @Test
    public void burgerGetPriceTest() {
        Burger burger = new Burger();
        burger.addIngredient(this.sauceIngredient);
        burger.addIngredient(this.fillingIngredient);
        burger.setBuns(this.bun);

        Assert.assertEquals(500.0F, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.addIngredient(this.sauceIngredient);
        burger.addIngredient(this.fillingIngredient);
        burger.setBuns(this.bun);

        Assert.assertEquals("(==== Вкусная булочка ====)\n" +
                        "= sauce tobasco =\n" +
                        "= filling cheese =\n" +
                        "(==== Вкусная булочка ====)\n" +
                        "\n" +
                        "Price: 500,000000\n",
                burger.getReceipt());
    }
}
