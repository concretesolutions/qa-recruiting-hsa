package desafioKatahpvf;

import java.util.List;

class aplicarRegla implements precio {

    private final ReglaPrecios regPrecios;
    private final List<producto> included;

    aplicarRegla(ReglaPrecios pricingRule, List<producto> included) {
        this.regPrecios = pricingRule;
        this.included = included;
    }

    @Override
    public Integer getPrice() {
        return regPrecios.getPrice();
    }

    List<producto> getIncluded() {
        return included;
    }
}
