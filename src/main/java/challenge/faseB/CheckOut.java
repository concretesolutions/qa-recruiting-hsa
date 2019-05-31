package challenge.faseB;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

/**
 * Contiene carro de compra y aplica descuentos de acuerdo a promociones actuales
 */

public class CheckOut {
    //Items en carro de compras
    private Map<String, Integer> checkedItems = new TreeMap<>();

    //Valor total a pagar
    private Double totalPrice = 0.0;

    //Recibe promociones actuales
    private Map<String, Promotion> promotionRules;

    //Formatea a dos decimales
    private DecimalFormat decimal = new DecimalFormat("#.##");

    public CheckOut(Map promotionRules) {
        this.promotionRules = promotionRules;
    }

    public Double getTotalPrice () {
        return this.totalPrice;
    }

    /**
     * Calcula total a pagar y aplica promociones
     */
    public void totalCalculator () {
        //Total sin descuentos
        System.out.println("TOTAL: " + decimal.format(totalPrice));

        //Aplica promociones y descuentos en caso de aplicar
        applyPromotions();

        System.out.println();
        //Total con descuentos
        System.out.println("TOTAL PRICE: " + decimal.format(totalPrice));
    }
    /**
     * Añade los items al carro
     */
    public void checkItem (String item) {
        if(checkedItems.containsKey(item))
            checkedItems.put(item, checkedItems.get(item) + 1);
        else
        {
            checkedItems.put(item, 1);
        }
        //Total hasta al momento por cada item añadido, sin descuentos
        totalPrice = totalPrice + promotionRules.get(item).getUnitPrice();
    }
    /**
     * Aplica promociones al carro de compra
     */
    private void applyPromotions() {
        //Iteracion por items en carro de compras
        for (Map.Entry<String, Integer> entry : checkedItems.entrySet()) {

            //Verifica si item en carro de compras tiene promocion
            if (promotionRules.containsKey(entry.getKey()) &&
                    promotionRules.get(entry.getKey()).getPromotionRequirement() != null) {

                //Valida tipo promocion a aplicar, en caso de existir mas promociones
                if (promotionRules.get(entry.getKey()).getPromotionType().equals("MOREFORLESS")) {
                    moreForLess(entry);
                }
            }
        }
    }
    /**
     * Aplica reglas de promocion MOREFORLESS
     */
    private void moreForLess (Map.Entry<String, Integer> entry) {
        //Verifica si cumple requisito de promocion
        if (promotionRules.get(entry.getKey()).getPromotionRequirement() <= entry.getValue()) {

            //Calcula valor sin promocion, cantidad del item * precio unitario
            Double sumNoPromo = entry.getValue() * promotionRules.get(entry.getKey()).getUnitPrice();

            //Cantidad veces se aplica valor promocion
            Integer timesPromo = entry.getValue() / promotionRules.get(entry.getKey()).getPromotionRequirement();
            //Cantidad items sin promocion
            Integer itemsNoPromo = (entry.getValue() % promotionRules.get(entry.getKey()).getPromotionRequirement());

            //Calcula valor total item aplicando promocion
            Double sumPromo = (timesPromo * promotionRules.get(entry.getKey()).getPromotionPrice()) +
                    (itemsNoPromo * promotionRules.get(entry.getKey()).getUnitPrice());

            //Calcula descuento aplicado al item, total sin promocion - total con promocion
            Double discount = sumNoPromo - sumPromo;

            System.out.println("MOREFORLESS Saved " + decimal.format(discount) + " on item " +entry.getKey());

            applyDiscount(discount);
        }
    }
    /**
     * Aplica descuento al total a pagar
     */
    public void applyDiscount (Double discount) {
        totalPrice = totalPrice - discount;
    }
}