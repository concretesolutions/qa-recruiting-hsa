package desafioKatahpvf;

import com.google.common.collect.Sets;

import java.util.Set;


//Constructor de reglas de precios 

class constReglas {

    private Set<ReglaPrecios> reglaPrecios;

    private constReglas(Set<ReglaPrecios> pricingRules) {
        this.reglaPrecios = pricingRules;
    }

    static constReglas create() {
        return new constReglas(Sets.newHashSet());
    }

    constReglas with(ReglaPrecios pricingRule) {
        Set<ReglaPrecios> newPricingRules = Sets.newHashSet(reglaPrecios);
        newPricingRules.add(pricingRule);
        return new constReglas(newPricingRules);
    }

    reglas build() {
        return new reglas(reglaPrecios);
    }
}
