package challenge.faseB;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Contiene promociones actuales
 * Item en Promocion, tipoPromocion, precioPromocion, requisitoPromocion
 *
 * Precios unitarios por item
 * "A", 50
 * "B", 30
 * "C", 20
 * "D", 15
 */
public class CheckOutTest
{

    @Test
    public void checkItemTest()
    {
        CheckOut co = new CheckOut(PromotionLibrary.promotionIndex);

        assertEquals(0.0, co.getTotalPrice(), 0.2);

        //Valores para posibles items: A - B - C - D
        co.checkItem("A");
        assertEquals(50.0, co.getTotalPrice(), 0.2);

        co.checkItem("A");
        assertEquals(100.0, co.getTotalPrice(), 0.2);

        co.checkItem("A");
        assertEquals(150.0, co.getTotalPrice(), 0.2);

        co.checkItem("D");
        assertEquals(165.0, co.getTotalPrice(), 0.2);

        co.checkItem("C");
        assertEquals(185.0, co.getTotalPrice(), 0.2);

        co.checkItem("B");
        assertEquals(215.0, co.getTotalPrice(), 0.2);

        co.checkItem("B");
        assertEquals(245.0, co.getTotalPrice(), 0.2);
    }

    @Test
    public void  totalCalculatorTest()
    {
        CheckOut co = new CheckOut(PromotionLibrary.promotionIndex);

        //Valores para posibles items: A - B - C - D
        co.checkItem("A");
        co.checkItem("A");
        co.checkItem("A");
        co.checkItem("D");
        co.checkItem("C");
        co.checkItem("B");
        co.checkItem("B");
        co.checkItem("B");
        co.checkItem("D");
        co.checkItem("A");
        co.checkItem("A");
        co.checkItem("B");

        co.totalCalculator();

        assertEquals(370.0, co.getTotalPrice(), 0.2);;
    }
}
