package desafioKatahpvf;

import desafioKatahpvf.modPrecios;
import desafioKatahpvf.producto;
import desafioKatahpvf.constReglas;
import desafioKatahpvf.reglas;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;

public class TestData {

    private static final Map<String, Integer> prices = Maps.newHashMap();

    static reglas distinctRules = constReglas.create()
            .with(new modPrecios(item("A"), 3, 130))
            .with(new modPrecios(item("B"), 2, 45))
            .build();

    static reglas indistinctRules = constReglas.create()
            .with(new modPrecios(item("A"), 7, 300))
            .with(new modPrecios(item("A"), 3, 130)) 
            .with(new modPrecios(item("B"), 2, 45))
            .build();

    static {
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("D", 15);
    }

    static producto item(String name) {
        return new producto(name, prices.get(name));
    }

    static Collection<producto> items(String names) {
        Collection<producto> items = Lists.newArrayList();
        for (int i = 0; i < names.length(); i++) {
            String current = names.substring(i, i + 1);
            items.add(TestData.item(current));
        }
        return items;
    }

}
