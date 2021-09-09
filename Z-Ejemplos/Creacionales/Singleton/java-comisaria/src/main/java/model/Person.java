package model;

public class Person {
    protected String cod;
    protected String nombres;
    protected String apellidos;
    protected int cedula;

    public Person(String cod, String nombres, String apellidos, int cedula) {
        this.cod = cod;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Persona con nombre: " + nombres + " " + apellidos 
                + ", identificada con la cedula N°: S" + cedula + 
                ", y registrada en nuestro sistema con el código: " + cod;
    }
}
