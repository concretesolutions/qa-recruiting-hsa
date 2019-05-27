import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;


public class CheckoutTest {

    HashMap<String, Item> config = ListOfItems.getListOfItems("listItems.conf");

    @Test
    public void checkPriceA(){

        Basket basket = new Basket();
        
        basket.addItems(config.get("itemA"),1);

        Assert.assertEquals(50,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAB(){
        Basket basket = new Basket();

        basket.addItems(config.get("itemA"),1);
        basket.addItems(config.get("itemB"),1);

        Assert.assertEquals(80,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceCDBA(){
        Basket basket = new Basket();

        basket.addItems(config.get("itemA"),1);
        basket.addItems(config.get("itemB"),1);
        basket.addItems(config.get("itemC"),1);
        basket.addItems(config.get("itemD"),1);

        Assert.assertEquals(115,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAA(){
        Basket basket = new Basket();

        basket.addItems(config.get("itemA"),2);

        Assert.assertEquals(100,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAA(){
        Basket basket = new Basket();

        basket.addItems(config.get("itemA"),3);

        Assert.assertEquals(130,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAAA(){
        Basket basket = new Basket();

        basket.addItems(config.get("itemA"),4 );

        Assert.assertEquals(180,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAAAA(){
        Basket basket = new Basket();

        basket.addItems(config.get("itemA"),5 );

        Assert.assertEquals(230,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAAAAA(){
        Basket basket = new Basket();

        basket.addItems(config.get("itemA"),6 );

        Assert.assertEquals(260,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAAB(){
        Basket basket = new Basket();

        basket.addItems(config.get("itemA"),3 );
        basket.addItems(config.get("itemB"),1 );

        Assert.assertEquals(160,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAABB(){
        Basket basket = new Basket();

        basket.addItems(config.get("itemA"),3 );
        basket.addItems(config.get("itemB"),2 );

        Assert.assertEquals(175,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceAAABBD(){
        Basket basket = new Basket();

        basket.addItems(config.get("itemA"),3 );
        basket.addItems(config.get("itemB"),2 );
        basket.addItems(config.get("itemD"),1 );

        Assert.assertEquals(190,basket.checkTotal(),0.0d);
    }

    @Test
    public void checkPriceDABABA(){
        Basket basket = new Basket();

        basket.addItems(config.get("itemA"),3 );
        basket.addItems(config.get("itemB"),2 );
        basket.addItems(config.get("itemD"),1 );

        Assert.assertEquals(190,basket.checkTotal(),0.0d);
    }

}
