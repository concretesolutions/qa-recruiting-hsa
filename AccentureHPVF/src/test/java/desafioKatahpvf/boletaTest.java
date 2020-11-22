package desafioKatahpvf;

import desafioKatahpvf.boleta;
import desafioKatahpvf.reglas;
import org.junit.Assert;
import org.junit.Test;

public class boletaTest {

    Integer price(String items) {
        return price(items, TestData.distinctRules);
    }

    Integer price(String names, reglas rules) {
        boleta checkout = new boleta(rules);
        TestData.items(names).forEach(checkout::scan);
        return checkout.total();
    }

    @Test
    public void testTotals() {
        Assert.assertEquals(Integer.valueOf(0), price(""));
        Assert.assertEquals(Integer.valueOf(50), price("A"));
        Assert.assertEquals(Integer.valueOf(80), price("AB"));
        Assert.assertEquals(Integer.valueOf(115), price("CDBA"));

        Assert.assertEquals(Integer.valueOf(100), price("AA"));
        Assert.assertEquals(Integer.valueOf(130), price("AAA"));
        Assert.assertEquals(Integer.valueOf(180), price("AAAA"));
        Assert.assertEquals(Integer.valueOf(230), price("AAAAA"));
        Assert.assertEquals(Integer.valueOf(260), price("AAAAAA"));
        Assert.assertEquals(Integer.valueOf(310), price("AAAAAAA"));

        Assert.assertEquals(Integer.valueOf(160), price("AAAB"));
        Assert.assertEquals(Integer.valueOf(175), price("AAABB"));
        Assert.assertEquals(Integer.valueOf(190), price("AAABBD"));
        Assert.assertEquals(Integer.valueOf(190), price("DABABA"));
    }

    @Test
    public void testIncremental() {
        boleta checkout = new boleta(TestData.distinctRules);

        Assert.assertEquals(Integer.valueOf(0), checkout.total());

        checkout.scan(TestData.item("A"));
        Assert.assertEquals(Integer.valueOf(50), checkout.total());

        checkout.scan(TestData.item("B"));
        Assert.assertEquals(Integer.valueOf(80), checkout.total());

        checkout.scan(TestData.item("A"));
        Assert.assertEquals(Integer.valueOf(130), checkout.total());

        checkout.scan(TestData.item("A"));
        Assert.assertEquals(Integer.valueOf(160), checkout.total());

        checkout.scan(TestData.item("B"));
        Assert.assertEquals(Integer.valueOf(175), checkout.total());
    }


    @Test
    public void testTotalsWithIndistinctRules() {
        Assert.assertEquals(Integer.valueOf(0), price("", TestData.indistinctRules));
        Assert.assertEquals(Integer.valueOf(130), price("ABABABABA", TestData.indistinctRules));

     
        Assert.assertEquals(Integer.valueOf(300), price("AAAAAAA", TestData.indistinctRules));
    }
}
