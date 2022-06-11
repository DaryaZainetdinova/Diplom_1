import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class bunTests {


    @Test
    public void getBunNameTest() {
        String name = "Вадим";
        Bun bun = new Bun(name, 78);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getBunPriseTest() {
        float priсe = 798.7F;
        Bun bun = new Bun("Марина", priсe);
        Assert.assertEquals(priсe, bun.getPrice(), 0);
    }
}
