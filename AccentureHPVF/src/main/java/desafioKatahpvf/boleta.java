package desafioKatahpvf;

import java.util.ArrayList;
import java.util.List;

class boleta {

    
    
    private final reglas rules;
    private final List<producto> itemsScaneados = new ArrayList<>();

    boleta(reglas rules) {
        this.rules = rules;
    }

    void scan(producto item) {
        itemsScaneados.add(item);
    }

    Integer total() {
        return rules.createContainer(itemsScaneados).getTotal();
    }
}
