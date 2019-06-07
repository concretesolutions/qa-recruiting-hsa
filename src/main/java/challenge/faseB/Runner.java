package challenge.faseB;

/**
 * Ignacio González Pozo - igonzalezp@gmail.com
 * Precios unitarios por item
 * "A",50
 * "B",30
 * "C",20
 * "D",15
 */
public class Runner
{
    public static void main( String[] args )
    {

        CheckOut co = new CheckOut(PromotionLibrary.promotionIndex);

        //Valores para posibles items: A - B - C - D
        co.checkItem("A");
        co.checkItem("A");
        co.checkItem("A");
        co.checkItem("D");
        co.checkItem("C");
        co.checkItem("D");
        co.checkItem("A");
        co.checkItem("A");
        co.checkItem("B");
        co.checkItem("B");
        co.checkItem("A");
        co.checkItem("A");
        co.checkItem("A");
        co.checkItem("D");
        co.checkItem("C");
        co.checkItem("D");
        co.checkItem("A");
        co.checkItem("A");
        co.checkItem("B");
        co.checkItem("B");
        co.totalCalculator();
    }
}
