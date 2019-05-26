import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Basket {

    private HashMap<Item,Integer> basketList = new HashMap<Item, Integer>();
    private double total = 0;

    public void addItems(Item i, Integer quantity){
        basketList.put(i,quantity);
    }

    public double checkTotal(){

        Iterator<Map.Entry<Item, Integer>> it = basketList.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Item, Integer> pair = it.next();
            Item item = pair.getKey();

            int quantity = pair.getValue();

            if (item.getPromotions()!=null){
                total = total + item.checkPromotion(quantity);
            }else {
                total = total + (quantity * item.getPrice());
            }
        }

        return total;
    }


}
