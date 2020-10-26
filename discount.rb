class Discount
#Se realiza la carga de variables cuando se inicializan las reglas, guardo la cantidad y el monto de descuento
    def initialize( quantity ,amount)
      @quantity = quantity
      @amount = amount
      puts "pasa por discount"

    end

    #Calculo el monto que se debe descontar, luego realizo la lógica para aplicar el descuento si es que aplica o no.
    def calculate_discount(quantity,normalPrice)
        discount = normalPrice * @quantity - @amount
            if quantity %  @quantity == 0               
                (quantity / @quantity) * discount 
            elsif quantity > @quantity
                quantity.div(@quantity) * discount 
            else 
                0
            end
    end
  end