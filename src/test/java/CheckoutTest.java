import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;


public class CheckoutTest {

    static BasketFromConfig basketFromConfig;

    @BeforeClass
    public static void beforeAllTestMethods() {

        CatalogFromConfig loadCatalog = new CatalogFromConfig();

        HashMap<String, Item>  config = loadCatalog.getListOfItems("catalog.conf");

        basketFromConfig = new BasketFromConfig(config);
    }

    @Test
    public void test_totals(){
        Assert.assertEquals(0, basketFromConfig.price(""),0.0d);

        Assert.assertEquals(50, basketFromConfig.price("A"),0.0d);
        Assert.assertEquals(80, basketFromConfig.price("AB"),0.0d);
        Assert.assertEquals(115, basketFromConfig.price("CDBA"),0.0d);

        Assert.assertEquals(100, basketFromConfig.price("AA"),0.0d);
        Assert.assertEquals(130, basketFromConfig.price("AAA"),0.0d);
        Assert.assertEquals(180, basketFromConfig.price("AAAA"),0.0d);
        Assert.assertEquals(230, basketFromConfig.price("AAAAA"),0.0d);
        Assert.assertEquals(260, basketFromConfig.price("AAAAAA"),0.0d);

        Assert.assertEquals(160, basketFromConfig.price("AAAB"),0.0d);
        Assert.assertEquals(175, basketFromConfig.price("AAABB"),0.0d);
        Assert.assertEquals(190, basketFromConfig.price("AAABBD"),0.0d);
        Assert.assertEquals(190, basketFromConfig.price("DABABA"),0.0d);

    }

}
