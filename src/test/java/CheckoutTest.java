import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;


public class CheckoutTest {

    static Basket basket;

    @BeforeClass
    public static void beforeAllTestMethods() {

        ConfigCatalog loadCatalog = new ConfigCatalog();

        HashMap<String, Item> config = loadCatalog.getListOfItems("catalog.conf");

        basket = new Basket(config);
    }

    @Test
    public void checkPriceA(){
        Assert.assertEquals(0,basket.price(""),0.0d);

        Assert.assertEquals(50,basket.price("A"),0.0d);
        Assert.assertEquals(80,basket.price("AB"),0.0d);
        Assert.assertEquals(115,basket.price("CDBA"),0.0d);

        Assert.assertEquals(100,basket.price("AA"),0.0d);
        Assert.assertEquals(130,basket.price("AAA"),0.0d);
        Assert.assertEquals(180,basket.price("AAAA"),0.0d);
        Assert.assertEquals(230,basket.price("AAAAA"),0.0d);
        Assert.assertEquals(260,basket.price("AAAAAA"),0.0d);

        Assert.assertEquals(160,basket.price("AAAB"),0.0d);
        Assert.assertEquals(175,basket.price("AAABB"),0.0d);
        Assert.assertEquals(190,basket.price("AAABBD"),0.0d);
        Assert.assertEquals(190,basket.price("DABABA"),0.0d);

    }

}
