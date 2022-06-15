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
                {"black bun", 100},
                {"white bun", 200},
                {"", 200},
                {null, 200},
                {"white bun", 0},
                {"white bun", -79},
                {"white bun", 7978764},
                {"white bunwhite bunwhite bunwhite bunwhite bunwhite bun", 90},
                {"y", 900},
                {"white bun", 1}
        });
    }

    @Test
    public void testBun() {
        Bun bun = new Bun(this.bunName, this.bunPrice);

        Assert.assertEquals(this.bunName, bun.getName());
        Assert.assertEquals(this.bunPrice, bun.getPrice(), 0);
    }
}
