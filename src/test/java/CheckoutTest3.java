import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class CheckoutTest3 {

    static BasketFromRulesApi rules;

    @BeforeClass
    public static void beforeAllTestMethods() {

        rules = new BasketFromRulesApi();

    }

    @Test
    public void test_totals(){
        Assert.assertEquals(0,rules.price(""),0.0d);

        Assert.assertEquals(50,rules.price("A"),0.0d);
        Assert.assertEquals(80,rules.price("AB"),0.0d);
        Assert.assertEquals(115,rules.price("CDBA"),0.0d);

        Assert.assertEquals(100,rules.price("AA"),0.0d);
        Assert.assertEquals(130,rules.price("AAA"),0.0d);
        Assert.assertEquals(180,rules.price("AAAA"),0.0d);
        Assert.assertEquals(230,rules.price("AAAAA"),0.0d);
        Assert.assertEquals(260,rules.price("AAAAAA"),0.0d);

        Assert.assertEquals(160,rules.price("AAAB"),0.0d);
        Assert.assertEquals(175,rules.price("AAABB"),0.0d);
        Assert.assertEquals(190,rules.price("AAABBD"),0.0d);
        Assert.assertEquals(190,rules.price("DABABA"),0.0d);

    }

}
