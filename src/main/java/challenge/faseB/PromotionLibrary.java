package challenge.faseB;

import java.util.Map;
import java.util.TreeMap;

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

public class PromotionLibrary {

    public static Map promotionIndex = new TreeMap<String, Promotion>();

    static {
        promotionIndex.put("A",
                new Promotion("MOREFORLESS", 130.0,3, 50.0));
        promotionIndex.put("B",
                new Promotion("MOREFORLESS", 45.0,2, 30.0));
        promotionIndex.put("C",
                new Promotion("MOREFORLESS", null,null, 20.0));
        promotionIndex.put("D",
                new Promotion("MOREFORLESS", null,null, 15.0));
    }
}
