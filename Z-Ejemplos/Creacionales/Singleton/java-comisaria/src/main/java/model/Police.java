package model;

import interfaces.ISaldo;

public class Police extends Person implements ISaldo {
    private int edad;
    private int rango;
    private int antiguedad;
    private double saldo;

    public Police(String cod, String nombres, String apellidos, int cedula, int edad, int rango, int antiguedad) {
        super(cod, nombres, apellidos, cedula);
        this.edad = edad;
        this.rango = rango;
        this.antiguedad = antiguedad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public int getRango() {
        return rango;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void calcularSaldo() {
        this.saldo = rango * antiguedad;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Policia, con " + edad 
                + " años, rango: " + rango 
                + ", antiguedad en la fuerza: " + antiguedad
                + ", salario: " + saldo;
    }
}