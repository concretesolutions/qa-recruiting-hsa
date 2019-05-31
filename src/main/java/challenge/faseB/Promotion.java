package challenge.faseB;

/**
 * Clase para asignacion de promociones a producto
 * tipoPromocion, precioPromocion, requisitoPromocion
 */

public class Promotion {
    private String promotionType;
    private Double promotionPrice;
    private Integer promotionRequirement;
    private Double unitPrice;

    public Promotion(String promotionType, Double promotionPrice, Integer promotionRequirement, Double unitPrice) {
        this.promotionType = promotionType;
        this.promotionPrice = promotionPrice;
        this.promotionRequirement = promotionRequirement;
        this.unitPrice = unitPrice;
    }

    public String getPromotionType(){
        return this.promotionType;
    }

    public Integer getPromotionRequirement(){
        return this.promotionRequirement;
    }

    public Double getPromotionPrice(){
        return this.promotionPrice;
    }

    public Double getUnitPrice(){
        return this.unitPrice;
    }
}
