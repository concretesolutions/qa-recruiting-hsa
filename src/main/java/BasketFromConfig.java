import java.util.HashMap;

public class BasketFromConfig implements RulesPromotion{

    private HashMap<String, Item> catalog;
    private HashMap<String, Item> basketList;
    private double total;

    public BasketFromConfig(HashMap<String, Item> config) {
        this.catalog = config;
        basketList = new HashMap<>();
        total = 0;
    }

    public void addItemToBasket(String productName){
        if(!productName.equals("")){
            Item item = catalog.get(productName);
            if(basketList.get(productName) != null){
                int aux = basketList.get(productName).getQuantity();
                item.setQuantity(++aux);
                basketList.put(productName,item);
            }else{
                int quantity = 1;
                item.setQuantity(quantity);
                basketList.put(productName,item);
            }
        }
    }

    public double checkTotal(){

        total = 0;

        basketList.forEach((name,item) -> {
            int quantity = item.getQuantity();
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

        if (arrayItems.length != 0){
            for (char sku:arrayItems) {
                String productName = String.valueOf(sku);
                addItemToBasket(productName);
            }
        }

        return checkTotal();
    }


}
