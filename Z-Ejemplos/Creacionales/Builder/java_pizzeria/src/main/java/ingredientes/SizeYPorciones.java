package ingredientes;

public class SizeYPorciones {
    private Size size;
    private int porciones;

    public SizeYPorciones(Size size, int porciones){
        this.size = size;
        this.porciones = porciones;
    }
    
    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getPorciones() {
        return porciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }

    @Override
    public String toString() {
        String espacio = "       ";
        return espacio 
            + "- Tamaño: " + size 
            + "\n" + espacio 
            + "- Porciones: " + porciones;
    }
}
