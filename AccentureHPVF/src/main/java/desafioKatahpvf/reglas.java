package desafioKatahpvf;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

class reglas {

    private Set<ReglaPrecios> pricingRuleSet;

    reglas(Set<ReglaPrecios> pricingRuleSet) {
        this.pricingRuleSet = pricingRuleSet;
    }

    contPrecios createContainer(List<producto> items) {
        contPrecios container = new contPrecios(items);

        Optional<contPrecios> optimized;
        while ((optimized = applyBestRule(container)).isPresent()) {
            container = optimized.get();
        }

        return container;
    }

    /**
     * Tries to apply any of the available pricing rules to the given object.
     * If multiple rules are applicable, the one with the biggest discount (smallest total) is chosen.
     *
     * @param items container of items with and without pricing rules applied
     * @return Optional.empty() if no rule could be applied, otherwise an Optional.of() with the new items container
     */
    private Optional<contPrecios> applyBestRule(contPrecios items) {
        Function<ReglaPrecios, Optional<contPrecios>> tryToApplyRule = rule -> rule.optimize(items);
        return pricingRuleSet.stream()
                .map(tryToApplyRule)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .min(contPrecios::compareByTotal);
    }
}
