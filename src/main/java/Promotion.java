public class Promotion {

    private String name;
    private int nro_items;
    private double price;

    public Promotion(String name, int nro_items, double price) {
        this.name = name;
        this.nro_items = nro_items;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNro_items() {
        return nro_items;
    }

    public void setNro_items(int nro_items) {
        this.nro_items = nro_items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
