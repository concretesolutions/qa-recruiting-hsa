import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.YamlRuleDefinitionReader;

import java.io.FileReader;
import java.util.HashMap;


public class BasketFromRulesYML implements RulesPromotion{

    Rules rules;
    private HashMap<String,Item> basketList;
    private double total;

    public BasketFromRulesYML(){

        basketList = new HashMap<>();
        total = 0;

        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());

        try {

            rules = ruleFactory.createRules(new FileReader("src/test/resources/rules.yml"));

        } catch (Exception e) {
            e.printStackTrace();
        }

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
