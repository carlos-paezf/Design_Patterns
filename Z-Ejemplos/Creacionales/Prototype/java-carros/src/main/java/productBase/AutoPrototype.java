package productBase;


public abstract class AutoPrototype implements Cloneable {
    protected String color, modelo;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public abstract AutoPrototype clonar();

    public abstract String descripcion();
}
