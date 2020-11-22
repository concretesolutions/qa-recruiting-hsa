package desafioKatahpvf;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class modPrecios implements ReglaPrecios {

    private final producto item;
    private final Integer cantidad;
    private final Integer total;

    modPrecios(producto item, Integer cantidad, Integer fixedTotal) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad Invalida: " + cantidad);
        }
        if (fixedTotal < 0) {
            throw new IllegalArgumentException("invalid total: " + fixedTotal);
        }
        this.item = item;
        this.cantidad = cantidad;
        this.total = fixedTotal;
    }

    @Override
    public Integer getPrice() {
        return total;
    }

    @Override
    public Optional<contPrecios> optimize(contPrecios container) {
        if (!canBeAppliedTo(container)) {
            return Optional.empty();
        }
        List<producto> pickedItems = relevantItems(container).subList(0, cantidad);
        aplicarRegla appliedRule = new aplicarRegla(this, pickedItems);
        return Optional.of(container.with(appliedRule));
    }

    boolean canBeAppliedTo(contPrecios items) {
        return relevantItems(items).size() >= cantidad;
    }

    private List<producto> relevantItems(contPrecios container) {
        List<producto> collect = container.getThingsWithPrice()
                .stream()
                .filter(this::equalsThisItem)
                .map(hasPrice -> (producto) hasPrice)
                .collect(Collectors.toList());
        return collect;
    }

    private boolean equalsThisItem(precio hasPrice) {
        return hasPrice.equals(this.item);
    }
}
