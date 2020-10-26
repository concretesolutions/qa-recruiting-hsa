require './discount.rb'
require './pricingRules.rb'

#Creo objeto con las reglas y creo las instancias de los items y de los descuentos.
  RULES = {
    "A" => PricingRules.new(50, Discount.new(3, 130)),
    "B" => PricingRules.new(30, Discount.new(2, 45)),
    "C" => PricingRules.new(20),
    "D" => PricingRules.new(15),
  }
  
  class CheckOut
  
    #Carga las reglas e inicializa el arreglo de los item que se irán agregando en los test
    def initialize(rules)
      @rules = rules
      @items = Hash[]
    end
  
    # Agrego los items desde el test, en el caso de que el item ya existe le sumo 1 más.
    def scan(item)
      @items[item] ||= 0
      @items[item] += 1
    end
  
    #Valido que el producto exista en las reglas, en el caso de existir utilizo el metodo de PricingRules price_item
    def price_item(item, quantity)
      if rule_item(item)
        rule_item(item).price_item(quantity)
      else
        puts "Invalid Item '#{item}'"
      end
    end

    def rule_item(item)
      @rules[item]
    end

    #Recorre los items y va sumando el total en el acumulador "sumAcum" aplicando los descuentos correspondientes.
    def total
        @items.inject(0)  {|sumAcum, (item, quantity)|
         sumAcum + price_item(item, quantity)
        }             
      end
  end