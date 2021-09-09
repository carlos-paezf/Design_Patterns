package model;

public class Administrativo extends Person{
    private String cargo;
    private String sector;

    public Administrativo(String cod, String nombres, String apellidos, int cedula, String cargo, String sector) {
        super(cod, nombres, apellidos, cedula);
        this.cargo = cargo;
        this.sector = sector;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Personal Administrativo. Sector: " + sector + ", Cargo: " + cargo;
    }
}
