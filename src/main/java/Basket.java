import java.util.HashMap;

public class Basket {

    private HashMap<String, Item> config;
    private HashMap<Item,Integer> basketList;
    private double total;

    public Basket(HashMap<String, Item> config) {
        this.config = config;
        basketList = new HashMap<>();
        total = 0;
    }

    private void addItemsToBasket(String productName, Integer quantity){
        Item item = config.get(productName);
        if(basketList.get(item) != null){
            int aux = basketList.get(item).intValue();
            basketList.put(item,++aux);
        }else{
            quantity = 1;
            basketList.put(item,quantity);
        }
    }

    private double checkTotal(){
        basketList.forEach((item,quantity) -> {
            if (item.getPromotions()!=null){
                total = total + item.checkPromotion(quantity);
            }else {
                total = total + (quantity * item.getPrice());
            }
        });

        return total;
    }

    public double price(String listOfItems){

        basketList = new HashMap<>();
        total = 0;

        char[] arrayItems = listOfItems.toCharArray();

        int quantity = 1;

        if (arrayItems.length != 0){
            for (char sku:arrayItems) {
                String productName = String.valueOf(sku);
                addItemsToBasket(productName,quantity);
            }
        }

        return checkTotal();
    }


}
