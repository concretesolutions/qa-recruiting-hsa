import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigObject;
import com.typesafe.config.ConfigValue;

import java.util.HashMap;

public class ListOfItems {

    private static Config defaultConfig;
    private static HashMap<String,Item> listOfItems;

    private  static Config getConfig(String file) {
        if (defaultConfig==null) {
             defaultConfig = ConfigFactory.parseResources(file);

        }
        return defaultConfig;
    }

    public static HashMap<String, Item> getListOfItems(String file){

        if (listOfItems==null) {

            defaultConfig = getConfig(file);

            final ConfigValue configItems = defaultConfig.getObject("products");

            listOfItems = new HashMap<>(((ConfigObject) configItems).size());

            ((ConfigObject) configItems).keySet().forEach(pname -> {

                ConfigObject productConfig = ((ConfigObject) configItems).toConfig().getObject(pname);
                String productName = productConfig.get("productName").render().replaceAll("^\"|\"$", "");
                String productPrice = productConfig.get("productPrice").render();

                Item item;
                Promotion promotion;

                if (productConfig.containsKey("promotion")){
                    ConfigObject promotionConfig = (ConfigObject) productConfig.get("promotion");
                    String promoName = promotionConfig.get("promoName").render().replaceAll("^\"|\"$", "");
                    String promoNroItems = promotionConfig.get("promoNroItems").render();
                    String promoPrice = promotionConfig.get("promoPrice").render();
                    promotion = new Promotion(promoName,Integer.parseInt(promoNroItems),Double.parseDouble(promoPrice));
                    item = new Item(productName,Double.parseDouble(productPrice),promotion);
                }else{
                    item = new Item(productName,Double.parseDouble(productPrice));
                }

                listOfItems.put(item.getName(),item);

            });

        }
        return listOfItems;
    }


}