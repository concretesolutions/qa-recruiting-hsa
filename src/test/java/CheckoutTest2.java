import org.junit.Assert;
import org.junit.Test;

public class CheckoutTest2 {

    Promotion promoA = new Promotion("promoA",3,160);
    Promotion promoB = new Promotion("promoB",2,175);

    Item itemA = new Item("A",50,promoA);
    Item itemB = new Item("B",30,promoB);
    Item itemC = new Item("C",20);
    Item itemD = new Item("D",15);

    @Test
    public void checkPriceA(){
        Basket basket = new Basket();

        basket.addItems(itemA,1);

        Assert.assertEquals(50,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAB(){
        Basket basket = new Basket();

        basket.addItems(itemA,1);
        basket.addItems(itemB,1);

        Assert.assertEquals(80,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceCDBA(){
        Basket basket = new Basket();

        basket.addItems(itemA,1);
        basket.addItems(itemB,1);
        basket.addItems(itemC,1);
        basket.addItems(itemD,1);

        Assert.assertEquals(115,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAA(){
        Basket basket = new Basket();

        basket.addItems(itemA,2);

        Assert.assertEquals(100,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAA(){
        Basket basket = new Basket();

        basket.addItems(itemA,3);

        Assert.assertEquals(130,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAAA(){
        Basket basket = new Basket();

        basket.addItems(itemA,4 );

        Assert.assertEquals(180,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAAAA(){
        Basket basket = new Basket();

        basket.addItems(itemA,5 );

        Assert.assertEquals(230,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAAAAA(){
        Basket basket = new Basket();

        basket.addItems(itemA,6 );

        Assert.assertEquals(260,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAAB(){
        Basket basket = new Basket();

        basket.addItems(itemA,3 );
        basket.addItems(itemB,1 );

        Assert.assertEquals(160,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAABB(){
        Basket basket = new Basket();

        basket.addItems(itemA,3 );
        basket.addItems(itemB,2 );

        Assert.assertEquals(175,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAABBD(){
        Basket basket = new Basket();

        basket.addItems(itemA,3 );
        basket.addItems(itemB,2 );
        basket.addItems(itemD,1 );

        Assert.assertEquals(190,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceDABABA(){
        Basket basket = new Basket();

        basket.addItems(itemA,3 );
        basket.addItems(itemB,2 );
        basket.addItems(itemD,1 );

        Assert.assertEquals(190,basket.checkTotal(),0.0d);
    }

}
