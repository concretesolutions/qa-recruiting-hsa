public class Item implements Rules{

    private String name;
    private double price;
    private Promotion promotions;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Item(String name, double price, Promotion promotion) {
        this.name = name;
        this.price = price;
        this.promotions = promotion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Promotion getPromotions() {
        return promotions;
    }

    public void setPromotions(Promotion promotions) {
        this.promotions = promotions;
    }

    public double checkPromotion(int quantity){

        double total = 0;

        if (quantity < this.promotions.getNro_items()){
            total = total + (quantity * this.price);
        }else{
            while (quantity >= this.promotions.getNro_items()){
                if(quantity>=this.promotions.getNro_items()){
                    total = total + this.promotions.getPrice();
                }else{
                    total = total + (quantity * this.price);
                }
                quantity = quantity-this.promotions.getNro_items();
            }
            total = total + (quantity * this.price);
        }

        return total;
    }
}
