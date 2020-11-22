package desafioKatahpvf;

import java.util.Objects;

class producto implements precio {

    private String nombre;
    private Integer precioUnitario;

    producto(String name, Integer unitPrice) {
        this.nombre = name;
        this.precioUnitario = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        producto item = (producto) o;
        return Objects.equals(nombre, item.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public Integer getPrice() {
        return precioUnitario;
    }

}
