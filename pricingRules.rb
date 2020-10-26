class PricingRules
  #Se realiza la carga de variables cuando se inicializan las reglas, guarda el precio inicial y la lógica de descuento
    def initialize(init, *discounts)
      @normalPrice = init
      @discounts = discounts
    end
  
    #Calculo el precio total del item más el descuento
    def price_item(quantity)
      @normalPrice * quantity - discount_item(quantity)
    end
  # Envío la cantidad y el precio normal para poder calcular el descuento
    def discount_item(quantity)
      @discounts.inject(0) { |sumAcum, discount|        
        sumAcum + discount.calculate_discount(quantity,@normalPrice)
    }
    end
  end