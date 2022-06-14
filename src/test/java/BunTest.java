import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {
    private String bunName;
    private float bunPrice;

    public BunTest(String name, float price) {
        this.bunName = name;
        this.bunPrice = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Вадим", 78.0F},
                {"Марина", 798.7F}
        });
    }

    @Test
    public void testBun() {
        Bun bun = new Bun(this.bunName, this.bunPrice);

        Assert.assertEquals(this.bunName, bun.getName());
        Assert.assertEquals(this.bunPrice, bun.getPrice(), 0);
    }
}
