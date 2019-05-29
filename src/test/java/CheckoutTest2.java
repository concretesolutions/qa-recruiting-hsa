import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;


public class CheckoutTest2 {

    static Basket basket;

    @BeforeClass
    public static void beforeAllTestMethods() {

        ConfigCatalog loadCatalog = new ConfigCatalog();

        HashMap<String, Item> config = loadCatalog.getListOfItems("catalog2.conf");

        basket = new Basket(config);
    }

    @Test
    public void checkPriceA(){
        Assert.assertEquals(0,basket.price(""),0.0d);

        Assert.assertEquals(50,basket.price("A"),0.0d);
        Assert.assertEquals(80,basket.price("AB"),0.0d);
        Assert.assertEquals(115,basket.price("CDBA"),0.0d);

        Assert.assertEquals(100,basket.price("AA"),0.0d);
        Assert.assertEquals(160,basket.price("AAA"),0.0d);
        Assert.assertEquals(210,basket.price("AAAA"),0.0d);
        Assert.assertEquals(260,basket.price("AAAAA"),0.0d);
        Assert.assertEquals(320,basket.price("AAAAAA"),0.0d);

        Assert.assertEquals(190,basket.price("AAAB"),0.0d);
        Assert.assertEquals(335,basket.price("AAABB"),0.0d);
        Assert.assertEquals(350,basket.price("AAABBD"),0.0d);
        Assert.assertEquals(350,basket.price("DABABA"),0.0d);

    }

}
