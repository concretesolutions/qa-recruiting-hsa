import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;

import java.util.HashMap;


public class BasketFromRulesApi implements RulesPromotion{

    Rules rules;
    private HashMap<String,Item> basketList;
    private double total;

    public BasketFromRulesApi(){

        basketList = new HashMap<>();
        total = 0;

        Rule itemA = new MVELRule()
                .name("item A")
                .description("1 item A for 50")
                .when("item.getName() == 'A'")
                .then("item.setPrice(item.getQuantity() * 50)");

        Rule itemB = new MVELRule()
                .name("item B")
                .description("1 item B for 30")
                .when("item.getName() == 'B'")
                .then("item.setPrice(item.getQuantity() * 30)");

        Rule itemC = new MVELRule()
                .name("item C")
                .description("1 item C for 20")
                .when("item.getName() == 'C'")
                .then("item.setPrice(item.getQuantity() * 20)");

        Rule itemD = new MVELRule()
                .name("item D")
                .description("1 item D for 15")
                .when("item.getName() == 'D'")
                .then("item.setPrice(item.getQuantity() * 15)");

        Rule promoA = new MVELRule()
                .name("promo A")
                .description("3 item A for 130")
                .when("item.getName().equals('A') && item.getQuantity() / 3 >= 1")
                .then("int q = item.getQuantity() / 3;  item.setPrice(item.getPrice() - q * 20)");

        Rule promoB = new MVELRule()
                .name("promo B")
                .description("2 item b for 45")
                .when("item.getName().equals('B') && item.getQuantity() / 2 >= 1")
                .then("int q = item.getQuantity() /2;  item.setPrice(item.getPrice() - q * 15)");



        rules = new Rules();
        rules.register(itemA);
        rules.register(itemB);
        rules.register(itemC);
        rules.register(itemD);
        rules.register(promoA);
        rules.register(promoB);

    }

    private double calculatePrice(Item item){
        RulesEngine rulesEngine = new DefaultRulesEngine();
        Facts facts = new Facts();

        facts.put("item", item);
        rulesEngine.fire(rules, facts);

        return item.getPrice();
    }

    public void addItemToBasket(String productName) {
        Item scannedItem = new Item(productName);
        Item item = basketList.get(scannedItem.getName());
        if (item == null) {
            scannedItem.setQuantity(1);
            basketList.put(productName, scannedItem);
        } else {
            Integer quantity = item.getQuantity();
            item.setQuantity(++quantity);
        }

    }

    public double checkTotal(){

        for (Item item : basketList.values()) {
            total = total + calculatePrice(item);
        }
        return total;

    }

    public double price(String productName) {
        basketList = new HashMap<>();
        total = 0;

        for (int i = 0; i < productName.length(); i++) {
            addItemToBasket(productName.substring(i, i + 1));
        }
        return checkTotal();

    }
}
