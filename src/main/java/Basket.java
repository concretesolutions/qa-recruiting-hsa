import java.util.HashMap;

public class Basket {

    private HashMap<Item,Integer> basketList = new HashMap<>();
    private double total = 0;

    public void addItems(Item i, Integer quantity){
        basketList.put(i,quantity);
    }

    public double checkTotal(){

        basketList.forEach((item,quantity) -> {
            if (item.getPromotions()!=null){
                total = total + item.checkPromotion(quantity);
            }else {
                total = total + (quantity * item.getPrice());
            }
        });

        return total;
    }


}
