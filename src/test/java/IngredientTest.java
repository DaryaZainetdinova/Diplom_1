import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Test
    public void getIngridientPriceTest() {
        float price = 67.7F;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "bbq", price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientNameTest() {
        String name = "чесночный";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, 90.0F);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest() {
        IngredientType sause = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(sause, "bbq", 90.0F);
        Assert.assertEquals(sause, ingredient.getType());
    }
}
