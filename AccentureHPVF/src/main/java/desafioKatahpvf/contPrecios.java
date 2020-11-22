package desafioKatahpvf;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

class contPrecios {

    private final Collection<? extends precio> productoPrecio;

    contPrecios(Collection<? extends precio> thingsWithPrice) {
        this.productoPrecio = thingsWithPrice;
    }

    Integer getTotal() {
        return productoPrecio.stream().mapToInt(precio::getPrice).sum();
    }

    int compareByTotal(contPrecios other) {
        return getTotal().compareTo(other.getTotal());
    }

    public Collection<? extends precio> getThingsWithPrice() {
        return productoPrecio;
    }

    contPrecios with(aplicarRegla regla) {
        List<precio> copy = Lists.newArrayList(productoPrecio);
        regla.getIncluded().forEach(copy::remove);
        copy.add(regla);
        return new contPrecios(copy);

    }
}
